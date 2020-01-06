package id.co.iconpln.controlflowapp.sharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preferences_form.*

class SharedPreferencesFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val EXTRA_TYPE_FORM = "extra_type_form"
        const val EXTRA_RESULT = "extra_result"
        const val RESULT_CODE = 101
        const val TYPE_ADD = 1
        const val TYPE_EDIT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_form)

        btnPrefFormSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnPrefFormSave){
            val name = etPrefFormName.text.toString().trim()
            val email = etPrefFormEmail.text.toString().trim()
            val age = etPrefFormAge.text.toString().trim()
            val handphone = etPrefFormHandphone.text.toString().trim()
            val hasReadingHobby = rgPrefFormHobby.checkedRadioButtonId == R.id.rbPrefFormReading

            if (name.isEmpty()){
                etPrefFormName.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (email.isEmpty()){
                etPrefFormEmail.error = resources.getString(R.string.sp_field_required)
                return
            }

            if(!isValidEmail(email)){
                etPrefFormEmail.error = resources.getString(R.string.sp_field_email_not_valid)
                return
            }

            if (age.isEmpty()){
                etPrefFormAge.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (handphone.isEmpty()){
                etPrefFormHandphone.error = resources.getString(R.string.sp_field_required)
                return
            }

            if (!handphone.isDigitsOnly()){
                etPrefFormHandphone.error = resources.getString(R.string.sp_field_digit_only)
                return
            }


            Toast.makeText(this, "$name $email $age $handphone $hasReadingHobby", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
