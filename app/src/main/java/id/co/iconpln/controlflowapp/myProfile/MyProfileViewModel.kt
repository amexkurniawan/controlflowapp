package id.co.iconpln.controlflowapp.myProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.models.myProfile.ProfileResponse
import id.co.iconpln.controlflowapp.network.MyProfileNetworkRepository

class MyProfileViewModel : ViewModel() {

    companion object {
        var errorMessage = ""
    }

    fun getProfile(token: String): MutableLiveData<ProfileResponse> {
        return MyProfileNetworkRepository().getProfile(token)
    }
}