package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        btnSubmit.setOnClickListener {
            val styleIntent = Intent(this, StyleActivity::class.java)
            startActivity(styleIntent)

            setOnClickButton()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Ame", "-- onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ame", "-- onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ame", "-- onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ame", "-- onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ame", "-- onRestart")
    }

    override fun onDestroy() {
        Log.d("Ame", "-- onDestroy")
        super.onDestroy()
    }

    private fun setOnClickButton() {
        btnSnackbar.setOnClickListener(this)
        btnSnackbarButton.setOnClickListener(this)
        btnSnackbarCustom.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSnackbar -> {

            }
            R.id.btnSnackbarButton -> {

            }
            R.id.btnSnackbarCustom -> {

            }
        }
    }
}
