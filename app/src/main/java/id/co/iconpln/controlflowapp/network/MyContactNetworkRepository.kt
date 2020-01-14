package id.co.iconpln.controlflowapp.network

import androidx.lifecycle.MutableLiveData
import id.co.iconpln.controlflowapp.models.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.models.myContact.ContactResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MyContactNetworkRepository { // gate for conect between view model and network

    fun fetchContact(): MutableLiveData<ArrayList<ContactResponse>> {
        val contactData = MutableLiveData<ArrayList<ContactResponse>>()
        val listContact = ArrayList<ContactResponse>()

        NetworkConfig.contactApi().fetchContacts().enqueue(object
            :retrofit2.Callback<BaseContactResponse<ContactResponse>> {
            override fun onFailure(call: Call<BaseContactResponse<ContactResponse>>, t: Throwable) {

                contactData.postValue(null)
            }

            override fun onResponse(
                call: Call<BaseContactResponse<ContactResponse>>,
                response: Response<BaseContactResponse<ContactResponse>>
            ) {

                if(response.isSuccessful){
                    val listContactSize = response.body()?.contacts?.size as Int

                    for(i in 0 until listContactSize){
                        listContact.add(response.body()?.contacts?.get(i) as ContactResponse)
                    }

                    contactData.postValue(listContact)
                }
            }

        })

        return contactData
    }
}