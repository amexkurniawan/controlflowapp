package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.models.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import retrofit2.Callback

class MyUserNetworkRepository {// gate for conect between view model and network

    fun getAllUser(): MutableLiveData<ArrayList<UserDataResponse>>{
        val userData = MutableLiveData<ArrayList<UserDataResponse>>()
        var listUser = ArrayList<UserDataResponse>()

        NetworkConfig.userAPI().getAllUsers().enqueue(object :
        Callback<BaseUserResponse<UserDataResponse>> {
            
        })
    }
}