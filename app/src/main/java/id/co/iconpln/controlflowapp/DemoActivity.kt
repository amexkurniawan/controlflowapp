package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        setOnClickButton()
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
        btnSubmit.setOnClickListener(this)
        btnSnackbar.setOnClickListener(this)
        btnSnackbarButton.setOnClickListener(this)
        btnSnackbarCustom.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSubmit -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }
            R.id.btnSnackbar -> {
                Snackbar.make(clDemo, "This is Snack", Snackbar.LENGTH_SHORT)
                    .show()
            }
            R.id.btnSnackbarButton -> {
                Snackbar.make(clDemo, "Message is deleted", Snackbar.LENGTH_SHORT)
                    .setAction("Undo", undoListener)
                    .show()

            }
            R.id.btnSnackbarCustom -> {
                val customSnackBar = Snackbar.make(clDemo, "This is custom snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Undo", undoListener)
                    .setActionTextColor(ContextCompat.getColor(this, R.color.button_snackbar))

                val snackbarView = customSnackBar.view
                val textSnackbar: TextView = snackbarView.findViewById(R.id.snackbar_text)
                textSnackbar.setTextColor(ContextCompat.getColor(this, R.color.text_snackbar))
                textSnackbar.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))

                customSnackBar.show()
            }
        }
    }

    private val undoListener = object : View.OnClickListener{
        override fun onClick(view: View) {
            Snackbar.make(clDemo, "Message is restored", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_demo, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
