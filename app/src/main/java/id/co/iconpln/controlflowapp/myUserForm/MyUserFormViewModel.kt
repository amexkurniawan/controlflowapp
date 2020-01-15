package id.co.iconpln.controlflowapp.myUserForm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.network.MyUserNetworkRepository

class MyUserFormViewModel: ViewModel() {

    fun createUser(userData: UserDataResponse)
            : MutableLiveData<UserDataResponse> {

        return MyUserNetworkRepository().createUser(userData)
    }

    fun updateUser(id: Int, userData: UserDataResponse)
            : MutableLiveData<UserDataResponse> {

        return MyUserNetworkRepository().updateUser(id, userData)
    }

    fun deleteUser(id: Int): MutableLiveData<UserDataResponse> {

        return MyUserNetworkRepository().deleteUser(id)
    }
}