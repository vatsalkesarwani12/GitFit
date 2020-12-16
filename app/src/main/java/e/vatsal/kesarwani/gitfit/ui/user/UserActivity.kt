package e.vatsal.kesarwani.gitfit.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import e.vatsal.kesarwani.gitfit.R
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
            // intent need to be parsed later
            BattleActivity.start(this)
        }

        viewBinding.imCancel1.setOnClickListener{
            viewBinding.group1.visibility = View.VISIBLE
            viewBinding.card1.visibility = View.GONE

            /**reset data for the model*/
        }

        viewBinding.imCancel2.setOnClickListener{
            viewBinding.group2.visibility = View.VISIBLE
            viewBinding.card2.visibility = View.GONE

            /**reset data for the model*/
        }
    }

    private fun fetchUser1() {

        viewModel.getUsers(viewModel.user1.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewBinding.group1.visibility = View.GONE
                        viewBinding.card1.visibility = View.VISIBLE

                        /**
                         * render data to the card1
                         * fetch repos in background*/

                        fetchRepo1()
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

                        /**
                         * render data to the card1
                         * fetch repos in background*/

                        fetchRepo2()
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

    /** After fetch repo1 and 2 are successful enable the start battle button
     * hide image view.*/

    private fun fetchRepo1() {

        viewModel.getRepo(viewModel.user1.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewModel.flag.value = viewModel.flag.value?.plus(1)
                        /** set a flag +1*/
                    }

                    Status.ERROR -> {
                        //todo show SnackBar
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })

    }

    private fun fetchRepo2() {

        viewModel.getRepo(viewModel.user2.value.toString()).observe(this, {
            it.let {
                when(it.status) {
                    Status.SUCCESS -> {
                        viewModel.flag.value = viewModel.flag.value?.plus(1)
                        /** set a flag +1*/
                    }

                    Status.ERROR -> {
                        //todo show SnackBar
                    }

                    Status.LOADING -> {
                        //progressBar
                    }
                }
            }
        })

    }
}