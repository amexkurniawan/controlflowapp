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

    fun getUsers(): MutableLiveData<ArrayList<UserDataResponse>> {
        val usersData = MutableLiveData<ArrayList<UserDataResponse>>()
        val listUsers = ArrayList<UserDataResponse>()

        NetworkConfig.userApi().fetchUsers().enqueue(object: Callback<BaseUserResponse> {
            override fun onFailure(call: Call<BaseUserResponse>, t: Throwable) {
                usersData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseUserResponse>,
                response: Response<BaseUserResponse>) {

                if (response.isSuccessful) {
                    val listSize = response.body()?.data?.size as Int

                    for (i in 0 until listSize) {
                        listUsers.add(response.body()?.data?.get(i) as UserDataResponse)
                    }
                    usersData.postValue(listUsers)
                }
            }

        })
        return usersData
    }

    fun updateUser(id: Int, userData: UserDataResponse): MutableLiveData<UserDataResponse> {
        val updatedUserData = MutableLiveData<UserDataResponse>()

        NetworkConfig.userApi().updateUser(id, userData)
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

        NetworkConfig.userApi().deleteUser(id).enqueue(object: Callback<DeleteUserResponse> {
            override fun onFailure(call: Call<DeleteUserResponse>, t: Throwable) {
                deletedUserData.postValue(null)
            }

            override fun onResponse(
                call: Call<DeleteUserResponse>,
                response: Response<DeleteUserResponse>) {

                if (response.isSuccessful) {
                    val deletedUserResponse = response.body()?.deleted_user as UserDataResponse
                    deletedUserData.postValue(deletedUserResponse)
                } else {
                    deletedUserData.postValue(null)
                }
            }

        })

        return deletedUserData
    }
}