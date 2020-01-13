package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.models.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyUserNetworkRepository {// gate for conect between view model and network

    fun getAllUser(): MutableLiveData<ArrayList<UserDataResponse>>{
        val userData = MutableLiveData<ArrayList<UserDataResponse>>()
        var listUser = ArrayList<UserDataResponse>()

        NetworkConfig.userAPI().getAllUsers().enqueue(object :
        Callback<BaseUserResponse<UserDataResponse>> {
            override fun onFailure(call: Call<BaseUserResponse<UserDataResponse>>, t: Throwable) {
                userData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseUserResponse<UserDataResponse>>,
                response: Response<BaseUserResponse<UserDataResponse>>
            ) {

                if(response.isSuccessful) {
                    val listUserSize = response.body()?.data?.size as Int

                    for(i in 0 until listUserSize) {
                        listUser.add(response.body()?.data?.get(i) as UserDataResponse)
                    }

                    userData.postValue(listUser)
                }
            }

        })

        return userData
    }
}