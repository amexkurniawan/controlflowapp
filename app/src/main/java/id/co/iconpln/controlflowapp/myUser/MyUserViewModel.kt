package id.co.iconpln.controlflowapp.myUser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MyUserViewModel : ViewModel() {
    private val listUser = MutableLiveData<ArrayList<MyUser>>()

    internal fun setContact(){
        val client = AsyncHttpClient()
        val listItemUser = ArrayList<MyUser>()
        val url = "https://api.androidhive.info/contacts/"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {

                    // get data json
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val arrayContacts = responseObject.getJSONArray("contacts")

                    // convert JSON Object to readable data
                    // data in JSON Object is read by ITS key, exp: id, name
                    for(i in 0 until arrayContacts.length()){
                        val user = arrayContacts.getJSONObject(i)
                        val userItem = MyUser()

                        userItem.id = user.getString("id")
                        userItem.name = user.getString("name")
                        userItem.address = user.getString("address")
                        userItem.mobile = user.getJSONObject("phone").getString("mobile")

                        listItemUser.add(userItem)
                    }

                    // post realtime latest value from Backgroud Thread
                    listUser.postValue(listItemUser)

                } catch (e: Exception){
                    Log.d("@@@MyUserException", e.message.toString())
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.d("@@@MyUserFailure", error.message.toString())
            }

        })
    }

    internal fun getContact(): LiveData<ArrayList<MyUser>> {
        return listUser
    }
}