package e.vatsal.kesarwani.gitfit.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import e.vatsal.kesarwani.gitfit.R
import e.vatsal.kesarwani.gitfit.data.model.RepoCountResponse
import e.vatsal.kesarwani.gitfit.data.model.ResultModel
import e.vatsal.kesarwani.gitfit.data.network.ApiHelper
import e.vatsal.kesarwani.gitfit.data.network.RetrofitBuilder
import e.vatsal.kesarwani.gitfit.databinding.ActivityUserBinding
import e.vatsal.kesarwani.gitfit.ui.BattleActivity
import e.vatsal.kesarwani.gitfit.ui.ViewModelFactory
import e.vatsal.kesarwani.gitfit.utils.Status

class UserActivity : AppCompatActivity() {

    companion object{
        fun start(context : Context) {
            context.startActivity(Intent(context, UserActivity::class.java))
        }
    }

    private lateinit var viewBinding : ActivityUserBinding

    lateinit var viewModel : UserViewModel

    private var score : Int = 0

    private var resultModel = ResultModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        setupViewModel()
        setUpUI()
        setUpObservers()
        onclick()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.api))
        ).get(UserViewModel::class.java)
    }

    private fun setUpUI() {
        viewBinding.viewModel = viewModel
    }

    private fun setUpObservers() {
        viewModel.user1.observe(this, {
            when(it.isNotEmpty()){
                false -> viewBinding.etUser1.error = null
            }
        })
        viewModel.user2.observe(this, {
            when(it.isNotEmpty()){
                false -> viewBinding.etUser2.error = null
            }
        })
        viewModel.flag.observe(this, {
            when(it==2){
                true -> {
                    viewBinding.imageView.visibility = View.GONE
                    viewBinding.btStartBattle.visibility = View.VISIBLE
                }
                false -> {
                    viewBinding.imageView.visibility = View.VISIBLE
                    viewBinding.btStartBattle.visibility = View.GONE
                }
            }
        })
    }

    private fun onclick() {
        viewBinding.btSubmit1.setOnClickListener{
            when(viewModel.user1.value.isNullOrEmpty()){
                true -> viewBinding.etUser1.error = "Enter username"
                false -> fetchUser1()
            }
        }

        viewBinding.btSubmit2.setOnClickListener{
            when(viewModel.user2.value.isNullOrEmpty()){
                true -> viewBinding.etUser2.error = "Enter username"
                false -> fetchUser2()
            }
        }

        viewBinding.btStartBattle.setOnClickListener {

            BattleActivity.start(
                    this,
                    resultModel
            )
        }

        viewBinding.imCancel1.setOnClickListener{
            viewBinding.group1.visibility = View.VISIBLE
            viewBinding.card1.visibility = View.GONE

            viewModel.flag.value = viewModel.flag.value?.minus(1)
        }

        viewBinding.imCancel2.setOnClickListener{
            viewBinding.group2.visibility = View.VISIBLE
            viewBinding.card2.visibility = View.GONE

            viewModel.flag.value = viewModel.flag.value?.minus(1)
        }
    }

    private fun fetchUser1() {

        viewModel.getUsers(viewModel.user1.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewBinding.group1.visibility = View.GONE
                        viewBinding.card1.visibility = View.VISIBLE

                        viewBinding.tvUserName1.text = it.data?.name

                        Glide.with(this)
                            .load(it.data?.avatarUrl)
                            .into(viewBinding.imUserImage1)

                        val model = ResultModel.User()

                        model.name = it.data?.name
                        model.avatarUrl = it.data?.avatarUrl
                        model.followers = it.data?.followers
                        model.following = it.data?.following
                        model.publicRepos = it.data?.publicRepos

                        resultModel.user1 = model

                        it.data?.followers?.let { it1 -> fetchRepo1(it1) }
                    }

                    Status.ERROR -> {
                        viewBinding.etUser1.error = it.message
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })
    }

    private fun fetchUser2() {

        viewModel.getUsers(viewModel.user2.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewBinding.group2.visibility = View.GONE
                        viewBinding.card2.visibility = View.VISIBLE

                        viewBinding.tvUserName2.text = it.data?.name

                        Glide.with(this)
                            .load(it.data?.avatarUrl)
                            .into(viewBinding.imUserImage2)

                        val model = ResultModel.User()

                        model.name = it.data?.name
                        model.avatarUrl = it.data?.avatarUrl
                        model.followers = it.data?.followers
                        model.following = it.data?.following
                        model.publicRepos = it.data?.publicRepos

                        resultModel.user2 = model

                        it.data?.followers?.let { it1 -> fetchRepo2(it1) }
                    }

                    Status.ERROR -> {
                        viewBinding.etUser2.error = it.message
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })
    }

    private fun fetchRepo1(follow : Int) {

        viewModel.getRepo(viewModel.user1.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewModel.flag.value = viewModel.flag.value?.plus(1)

                        scoreCalculate(it.data!!, follow, true)
                    }

                    Status.ERROR -> {
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })

    }

    private fun fetchRepo2(follow : Int) {

        viewModel.getRepo(viewModel.user2.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewModel.flag.value = viewModel.flag.value?.plus(1)

                        scoreCalculate(it.data!!, follow, false)
                    }

                    Status.ERROR -> {
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })

    }

    private fun scoreCalculate(list : RepoCountResponse, follow: Int, user : Boolean) {
        var star  = 0
        var fork  = 0
        var publicRepo = 0
        for (element in list){
            if (element.fork == false) {
                publicRepo++
                star += element.stargazersCount!!*3  /**star gives you 3 points */
                fork += element.forksCount!!*5       /**fork gives you 5 points */
            }                                        /**follow gives you 1 point */
        }                                            /**public repo give 1 point only which you are owner */

        score = star+fork+follow+publicRepo
        if (user) {
            resultModel.score1 = score
        }else {
            resultModel.score2 = score
        }
    }
}