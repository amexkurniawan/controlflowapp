package id.co.iconpln.controlflowapp.sharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preferences_form.*

class SharedPreferencesFormActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_form)

        btnPrefFormSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefFormSave){
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        }
    }
}
