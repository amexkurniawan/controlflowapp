package id.co.iconpln.controlflowapp.myProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.myContact.ProfileUser
import id.co.iconpln.controlflowapp.myProfileLogin.MyProfileLoginActivity
import kotlinx.android.synthetic.main.activity_my_profile.*

class MyProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var myProfileViewModel: MyProfileViewModel
    private var profileLoginResponse: ProfileLoginResponse? = null
    private lateinit var profileUserPreference: ProfileUserPreference
    private lateinit var profileUser: ProfileUser

    companion object{
        const val REQUEST_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        clickListener()
        initialViewModel()
        showExistingPreferences()
    }

    private fun initialViewModel() {
        myProfileViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MyProfileViewModel::class.java)
    }

    private fun clickListener(){
        btnProfileToLogin.setOnClickListener(this)
        btnProfileLogout.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == REQUEST_CODE){
            if(resultCode == MyProfileLoginActivity.RESULT_CODE){
                profileLoginResponse = data?.getParcelableExtra(
                    MyProfileLoginActivity.EXTRA_PROFILE_RESULT
                ) as ProfileLoginResponse
            }
        }
    }

    private fun saveProfileUserPreference(){
        if(profileLoginResponse != null){
            profileUser.userToken = profileLoginResponse?.token
            profileUserPreference.setProfileUser(profileUser)
            Toast.makeText(this, "Token Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showExistingPreferences() {
        profileUserPreference = ProfileUserPreference(this)
        profileUser = profileUserPreference.getProfileUser()

        if(!profileUserPreference.getProfileUser().userToken.isNullOrEmpty()){

        } else {
            showLogoutProfile()
        }
    }

    private fun showLogoutProfile() {
        pbProfileLoading.visibility = View.GONE
        llProfileContent.visibility = View.VISIBLE
        tvProfileWarning.visibility - View.VISIBLE
        btnProfileToLogin.visibility = View.VISIBLE
        btnProfileLogout.visibility = View.GONE

        tvProfileId.text = resources.getString(R.string.profile_empty)
        tvProfileName.text = resources.getString(R.string.profile_empty)
        tvProfileEmail.text = resources.getString(R.string.profile_empty)
        tvProfileHandphone.text = resources.getString(R.string.profile_empty)
    }

    override fun onClick(view: View) {
        when(view.id){

            R.id.btnProfileToLogin -> {
                val intent = Intent(this, MyProfileLoginActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }
            R.id.btnProfileLogout -> {

            }

        }
    }
}
