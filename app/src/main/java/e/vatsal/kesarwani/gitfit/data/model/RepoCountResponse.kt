package e.vatsal.kesarwani.gitfit.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class RepoCountResponse : ArrayList<RepoCountResponse.RepoResponseItem>() {

    @Parcelize
    data class RepoResponseItem(

            @SerializedName("fork")
            var fork: Boolean? = null,

            @SerializedName("stargazers_count")
            var stargazersCount: Int? = null,

            @SerializedName("forks_count")
            var forksCount: Int? = null,

    ) : Parcelable
}