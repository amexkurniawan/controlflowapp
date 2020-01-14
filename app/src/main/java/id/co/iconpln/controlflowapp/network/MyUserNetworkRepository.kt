package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.models.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.models.myUser.DeleteUserResponse
import id.co.iconpln.controlflowapp.models.myUser.UpdatedUserResponse
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

    fun updateUser(id: Int, userData: UserDataResponse): MutableLiveData<UserDataResponse> {
        val updatedUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userAPI().updateUser(id, userData)
            .enqueue(object: Callback<UpdatedUserResponse> {

                override fun onFailure(call: Call<UpdatedUserResponse>, t: Throwable) {
                    updatedUserData.postValue(null)
                }

                override fun onResponse(
                    call: Call<UpdatedUserResponse>,
                    response: Response<UpdatedUserResponse>) {

                    if (response.isSuccessful) {
                        val updatedUserResponse = response.body()?.updated_user as UserDataResponse
                        updatedUserData.postValue(updatedUserResponse)
                    } else {
                        updatedUserData.postValue(null)
                    }
                }

            })

        return updatedUserData
    }

    fun deleteUser(id: Int): MutableLiveData<UserDataResponse> {
        val deletedUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userAPI().deleteUser(id).enqueue(object: Callback<DeleteUserResponse> {
            override fun onFailure(call: Call<DeleteUserResponse>, t: Throwable) {
                deletedUserData.postValue(null)
            }

            override fun onResponse(
                call: Call<DeleteUserResponse>,
                response: Response<DeleteUserResponse>) {

                if(response.isSuccessful){
                    val deleteUserResponse = response.body()?.deleted_user as UserDataResponse
                    deletedUserData.postValue(deleteUserResponse)
                } else {
                    deletedUserData.postValue(null)
                }

            }

        })

        return deletedUserData
    }
}