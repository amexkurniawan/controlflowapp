package id.co.iconpln.controlflowapp.myContact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.models.myContact.ContactResponse
import id.co.iconpln.controlflowapp.network.MyContactNetworkRepository
import org.json.JSONObject

class MyContactViewModel : ViewModel() {

    fun getListContact(): MutableLiveData<ArrayList<ContactResponse>> {
        return MyContactNetworkRepository().fetchContact()
    }
}