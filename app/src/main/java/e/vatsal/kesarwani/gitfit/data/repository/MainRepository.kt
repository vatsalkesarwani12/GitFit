package e.vatsal.kesarwani.gitfit.data.repository

import e.vatsal.kesarwani.gitfit.data.network.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUser(user : String) = apiHelper.getUser(user)

    suspend fun getRepo(user: String) = apiHelper.getRepo(user)
}