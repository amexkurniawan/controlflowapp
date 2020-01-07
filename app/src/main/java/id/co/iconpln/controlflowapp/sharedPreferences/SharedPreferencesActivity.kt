package id.co.iconpln.controlflowapp.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userPreferences: UserPreferences
    private var isPreferencesEmpty = false
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        btnPrefSave.setOnClickListener(this)

        supportActionBar?.title = "My User Preference"
        userPreferences = UserPreferences(this)
        showExistingPreference()
    }

    private fun showExistingPreference(){
        user = userPreferences.getUser()
        populateView(user)
        checkForm(user)
    }

    private fun checkForm(user: User) {
        when {
            user.name.toString().isNotEmpty() -> {
                btnPrefSave.text = resources.getText(R.string.sp_change)
                isPreferencesEmpty = false
            }
            else -> {
                btnPrefSave.text = resources.getText(R.string.sp_save)
                isPreferencesEmpty = true
            }
        }
    }

    private fun populateView(user: User) {
        tvPrefName.text = if (user.name.toString().isEmpty())
            "Tidak Ada" else user.name
        tvPrefAge.text = if (user.age.toString().isEmpty())
            "Tidak Ada" else user.age.toString()
        tvPrefEmail.text = if (user.email.toString().isEmpty())
            "Tidak Ada" else user.email
        tvPrefHandphone.text = if (user.handphone.toString().isEmpty())
            "Tidak Ada" else user.handphone
        tvPrefHobby.text = if (!user.hasReadingHobby)
            "Tidak Membaca" else "Membaca"
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btnPrefSave){
            val sharedPrefFormIntent = Intent(this, SharedPreferencesFormActivity::class.java)
            startActivity(sharedPrefFormIntent)
        }
    }
}
