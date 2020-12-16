package e.vatsal.kesarwani.gitfit.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import e.vatsal.kesarwani.gitfit.data.repository.MainRepository
import e.vatsal.kesarwani.gitfit.utils.Resource
import kotlinx.coroutines.Dispatchers

class UserViewModel constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    var user1 : MutableLiveData<String> = MutableLiveData()
    var user2 : MutableLiveData<String> = MutableLiveData()
    var flag : MutableLiveData<Int> = MutableLiveData(0)

    fun getUsers(user: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUser(user)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Something went wrong"))
        }
    }

    fun getRepo(user : String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getRepo(user)))
        } catch (exception : Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Something went wrong"))
        }
    }

}