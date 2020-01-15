package id.co.iconpln.controlflowapp.myUser


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.network.MyUserNetworkRepository

class MyUserViewModel: ViewModel() {

    fun getUser(id: Int): MutableLiveData<UserDataResponse>{
        return MyUserNetworkRepository().getUser(id)
    }

    fun getListUsers(): MutableLiveData<ArrayList<UserDataResponse>> {
        return MyUserNetworkRepository().getUsers()
    }
}