package e.vatsal.kesarwani.gitfit.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultModel(

        var user1 : User? = null,

        var score1: Int? = null,

        var user2 : User? = null,

        var score2: Int? = null,

) : Parcelable {

    @Parcelize
    data class User(

            var avatarUrl : String? = null,

            var followers: Int? = null,

            var following: Int? = null,

            var name: String? = null,

            var publicRepos: Int? = null

    ) : Parcelable

}