package e.vatsal.kesarwani.gitfit.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import e.vatsal.kesarwani.gitfit.R
import e.vatsal.kesarwani.gitfit.data.model.ResultModel
import e.vatsal.kesarwani.gitfit.databinding.ActivityBattleBinding

class BattleActivity : AppCompatActivity() {

    companion object{
        private const val INTENT_BATTLE_DATA = "intent_battle_data"
        fun start(context: Context, resultModel: ResultModel) {
            val intent = Intent(context, BattleActivity::class.java)
            intent.putExtra(INTENT_BATTLE_DATA, resultModel)
            context.startActivity(intent)
        }
    }

    private lateinit var viewBinding : ActivityBattleBinding

    private var resultModel = ResultModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_battle)

        handleIntent()
        updateUI()
    }

    private fun handleIntent() {
        resultModel = intent.getParcelableExtra<ResultModel>(INTENT_BATTLE_DATA) as ResultModel
    }

    private fun updateUI() {
        when(resultModel.score1!! >= resultModel.score2!!){
            true -> {

                /**Winner */
                Glide.with(this)
                        .load(resultModel.user1?.avatarUrl)
                        .into(viewBinding.imUserImage1)

                viewBinding.tvUserName1.text = resultModel.user1?.name

                viewBinding.tvUserScore1.text = resultModel.score1.toString()

                viewBinding.tvPublicRepo1.text = "Public Repo : ${resultModel.user1?.publicRepos}"

                viewBinding.tvFollowersUser1.text = resultModel.user1?.followers.toString()

                viewBinding.tvFollowingUser1.text = resultModel.user1?.following.toString()

                /**Loser */

                Glide.with(this)
                        .load(resultModel.user2?.avatarUrl)
                        .into(viewBinding.imUserImage2)

                viewBinding.tvUserName2.text = resultModel.user2?.name

                viewBinding.tvUserScore2.text = resultModel.score2.toString()

                viewBinding.tvPublicRepo2.text = "Public Repo : ${resultModel.user2?.publicRepos}"

                viewBinding.tvFollowersUser2.text = resultModel.user2?.followers.toString()

                viewBinding.tvFollowingUser2.text = resultModel.user2?.following.toString()

            }
            false -> {

                /**Winner */
                Glide.with(this)
                        .load(resultModel.user1?.avatarUrl)
                        .into(viewBinding.imUserImage2)

                viewBinding.tvUserName2.text = resultModel.user1?.name

                viewBinding.tvUserScore2.text = resultModel.score1.toString()

                viewBinding.tvPublicRepo2.text = "Public Repo : ${resultModel.user1?.publicRepos}"

                viewBinding.tvFollowersUser2.text = resultModel.user1?.followers.toString()

                viewBinding.tvFollowingUser2.text = resultModel.user1?.following.toString()

                /**Loser */

                Glide.with(this)
                        .load(resultModel.user2?.avatarUrl)
                        .into(viewBinding.imUserImage1)

                viewBinding.tvUserName1.text = resultModel.user2?.name

                viewBinding.tvUserScore1.text = resultModel.score2.toString()

                viewBinding.tvPublicRepo1.text = "Public Repo : ${resultModel.user2?.publicRepos}"

                viewBinding.tvFollowersUser1.text = resultModel.user2?.followers.toString()

                viewBinding.tvFollowingUser1.text = resultModel.user2?.following.toString()

            }
        }
    }
}