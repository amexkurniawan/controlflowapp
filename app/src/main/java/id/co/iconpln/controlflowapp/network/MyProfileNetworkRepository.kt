package id.co.iconpln.controlflowapp.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.models.myProfile.BaseProfileResponse
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileNetworkRepository {

    fun doLogin(profileLoginUser: ProfileLoginUser): MutableLiveData<ProfileLoginResponse>{

        val loginData = MutableLiveData<ProfileLoginResponse>()

        NetworkConfig.profileApi().loginUser(profileLoginUser)
            .enqueue(object : Callback<BaseProfileResponse<ProfileLoginResponse>> {
                override fun onFailure(
                    call: Call<BaseProfileResponse<ProfileLoginResponse>>,
                    t: Throwable
                ) {

                    // on failure code
                    loginData.postValue(null)
                }

                override fun onResponse(
                    call: Call<BaseProfileResponse<ProfileLoginResponse>>,
                    response: Response<BaseProfileResponse<ProfileLoginResponse>>
                ) {

                    // on response
                    if(response.isSuccessful){
                        // Response 200
                        val loginResponse = response.body()?.data
                        loginData.postValue(loginResponse)
                        Log.d("@@@Profile", "${loginResponse?.customer?.email} -- LOGIN")

                    } else {
                        // Response 400
                        loginData.postValue(null)
                    }
                }
            })

        return loginData
    }
}