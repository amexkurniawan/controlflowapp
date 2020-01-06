package id.co.iconpln.controlflowapp.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        btnPrefSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btnPrefSave){
            val sharedPrefFormIntent = Intent(this, SharedPreferencesFormActivity::class.java)
            startActivity(sharedPrefFormIntent)
        }
    }
}