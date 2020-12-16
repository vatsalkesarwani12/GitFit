package e.vatsal.kesarwani.gitfit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import e.vatsal.kesarwani.gitfit.data.network.ApiHelper
import e.vatsal.kesarwani.gitfit.data.repository.MainRepository
import e.vatsal.kesarwani.gitfit.ui.user.UserViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
