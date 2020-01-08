package id.co.iconpln.controlflowapp.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header

class ContactViewModel : ViewModel() {
    private val listContact = MutableLiveData<ArrayList<Contact>>()

    internal fun setContact(){
        val client = AsyncHttpClient()
        val listContacts = ArrayList<Contact>()
        val url = "https://api.androidhive.info/contacts/"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {

            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {

            }

        })
    }

    internal fun getContact(): LiveData<ArrayList<Contact>>{
        return listContact
    }
}