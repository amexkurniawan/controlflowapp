package id.co.iconpln.controlflowapp.backgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_background_thread.*

class BackgroundThreadActivity : AppCompatActivity(), View.OnClickListener {

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
            R.id.btnThreadWorker -> {}
            R.id.btnThreadHandler -> {}
            R.id.btnThreadAsyncTask -> {}
            R.id.btnThreadCoroutine -> {}
            R.id.btnThreadCoroutineAscy -> {}
        }
    }
}
