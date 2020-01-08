package id.co.iconpln.controlflowapp.contact

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import java.lang.Exception

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
                try {
                    
                } catch (e: Exception){
                    Log.d("@@@ContactException", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("@@@ContactFailure", error.message.toString())
            }

        })
    }

    internal fun getContact(): LiveData<ArrayList<Contact>>{
        return listContact
    }
}