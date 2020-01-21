package id.co.iconpln.controlflowapp.myProfileRegister

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.models.myProfile.ProfileRegisterUser
import id.co.iconpln.controlflowapp.models.myProfile.ProfileResponse
import id.co.iconpln.controlflowapp.network.MyProfileNetworkRepository

class MyProfileRegisterViewModel : ViewModel(){
    fun register(profileRegisterUser: ProfileRegisterUser): MutableLiveData<ProfileResponse{
        return MyProfileNetworkRepository().doRegister(profileRegisterUser)
    }
}