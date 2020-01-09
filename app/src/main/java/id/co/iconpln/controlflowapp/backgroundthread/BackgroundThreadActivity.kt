package id.co.iconpln.controlflowapp.backgroundthread

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_background_thread.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.ref.WeakReference
import java.net.URL

class BackgroundThreadActivity : AppCompatActivity(), View.OnClickListener, ContactAsyncTaskCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_thread)
        click()
    }

    private fun click(){
        btnThreadWorker.setOnClickListener(this)
        btnThreadHandler.setOnClickListener(this)
        btnThreadAsyncTask.setOnClickListener(this)
        btnThreadCoroutine.setOnClickListener(this)
        btnThreadCoroutineAscy.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnThreadWorker -> {
                /* // Can't call Network in main Thread
                val text = URL("https://api.androidhive.info/contacts/").readText()
                tvThreadWorkerResult.text = text
                */

                Thread(Runnable {
                    val contactResultText = URL("https://api.androidhive.info/contacts/").readText()
                    // Can't call UI in Background Thread
                    //tvThreadWorkerResult.text = contactResultText

                    // TO access ui in background thread
                    tvThreadWorkerResult.post(Runnable {
                        tvThreadWorkerResult.text = contactResultText
                    })
                }).start()
            }

            R.id.btnThreadHandler -> {
                Thread(Runnable {
                    val contactResultText = URL("https://api.androidhive.info/contacts/").readText()
                    val msg = Message.obtain()
                    msg.obj = contactResultText
                    msg.target = contactHandler
                    msg.sendToTarget()
                }).start()
            }

            R.id.btnThreadAsyncTask -> {
                val contactUrl = URL("https://api.androidhive.info/contacts/")
                FetchContactAsyncTask(this).execute(contactUrl)
            }

            R.id.btnThreadCoroutine -> {
                runBlocking {
                    launch {
                        delay(1000)
                        tvThreadCoroutineResult.text = "Coroutine!"
                    }
                }
            }

            R.id.btnThreadCoroutineAscy -> {}
        }
    }

    private val contactHandler = Handler() { message: Message ->
        tvThreadHandlerResult.text = message.obj as String
        true
    }

    override fun onPreExecute() {
        pbThreadAsyncProgress.visibility = View.VISIBLE
        tvThreadAsyncResult.visibility = View.GONE
    }

    override fun onProgressUpdate(vararg values: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: String?) {
        pbThreadAsyncProgress.visibility = View.GONE
        tvThreadAsyncResult.visibility = View.VISIBLE
        tvThreadAsyncResult.text = result
    }

    //<URL, Progres, Result>
    class FetchContactAsyncTask(val listener: ContactAsyncTaskCallBack): AsyncTask<URL, Int, String>(){
        // using WeakReference to avoid memory leak in AsyncTask
        private val contactListener: WeakReference<ContactAsyncTaskCallBack>
                = WeakReference(listener)

        override fun onPreExecute() {
            super.onPreExecute()

            val myListener = contactListener.get()
            myListener?.onPreExecute()
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            val myListener = contactListener.get()
            myListener?.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val myListener = contactListener.get()
            myListener?.onPostExecute(result)
        }

        override fun doInBackground(vararg urls: URL): String {
            val urlResult = urls[0].readText()
            return urlResult
        }
    }
}

interface ContactAsyncTaskCallBack {
    fun onPreExecute()
    fun onProgressUpdate(vararg values: Int?)
    fun onPostExecute(result: String?)
}