package id.co.iconpln.controlflowapp.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
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
        const val EXTRA_USER = "USER"
    }

    private lateinit var user: User
    private var formType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_form)

        getIntentExtra()
        btnPrefFormSave.setOnClickListener(this)
        setupForm("", "")
        setupFormType()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getIntentExtra(){
        user = intent.getParcelableExtra(EXTRA_USER) as User
        formType = intent.getIntExtra(EXTRA_TYPE_FORM, 0)
    }

    private fun setupForm(actionBarTitle: String, btnTitle: String){
        supportActionBar?.title = actionBarTitle
        btnPrefFormSave.text = btnTitle
    }

    private fun setupFormType(){
        when(formType){
            TYPE_ADD -> {
                setupForm("Tambah Baru", "Simpan")
            }
            TYPE_EDIT -> {
                setupForm("Ubah", "Update")
                showPreferencesForm()
            }
        }
    }

    private fun showPreferencesForm(){
        etPrefFormName.setText(user.name)
        etPrefFormEmail.setText(user.email)
        etPrefFormAge.setText(user.age.toString())
        etPrefFormHandphone.setText(user.handphone)
        rbPrefFormReading.isChecked = user.hasReadingHobby
        rbPrefFormNotReading.isChecked = !user.hasReadingHobby
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

            saveUser(name, email, age, handphone, hasReadingHobby)
            val resultIntent = Intent().putExtra(EXTRA_RESULT, user)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun saveUser(name: String, email: String, age: String, handphone: String, hasReadingHobby: Boolean){
        val userPreferences = UserPreferences(this)
        user.name = name
        user.email = email
        user.age = Integer.parseInt(age)
        user.handphone = handphone
        user.hasReadingHobby = hasReadingHobby

        userPreferences.setUser(user)

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
