package e.vatsal.kesarwani.gitfit.data.network

import e.vatsal.kesarwani.gitfit.data.model.RepoCountResponse
import e.vatsal.kesarwani.gitfit.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("users/{user}/repos")
    suspend fun getRepos(
        @Path("user") user : String
    ) : RepoCountResponse

    @GET("users/{user}")
    suspend fun getUser(
        @Path("user") user : String
    ) : UserResponse

}