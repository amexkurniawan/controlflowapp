package id.co.iconpln.controlflowapp.myProfileLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginUser
import id.co.iconpln.controlflowapp.myProfile.MyProfileViewModel
import id.co.iconpln.controlflowapp.myProfileRegister.MyProfileRegisterActivity
import kotlinx.android.synthetic.main.activity_my_profile_login.*

class MyProfileLoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MyProfileLoginViewModel

    companion object{
        const val EXTRA_PROFILE_RESULT = "extra_profile_result"
        const val RESULT_CODE = 201
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_login)

        initViewModel()
        clickListener()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileLoginViewModel::class.java)
    }

    private fun clickListener() {
        btnProfileLogin.setOnClickListener(this)
        tvProfileLoginRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnProfileLogin -> {
                //Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
                fetchProfileData(
                    ProfileLoginUser(
                        etProfileLoginEmail.text.toString(),
                        etProfileLoginPassword.text.toString()
                    )
                )
            }
            R.id.tvProfileLoginRegister -> {
                startActivity(Intent(this, MyProfileRegisterActivity::class.java) )
            }
        }
    }

    private fun fetchProfileData(profileLoginUser: ProfileLoginUser) {

        viewModel.login(profileLoginUser).observe(this, Observer {
            loginResponse ->
                if (loginResponse != null) {
                    Toast.makeText(this, "Success login " + "${loginResponse.customer.email}", Toast.LENGTH_SHORT).show()
                    openProfilePage(loginResponse)
                } else {
                    Toast.makeText(this, "Login Failed ${MyProfileViewModel.errorMessage}", Toast.LENGTH_SHORT).show()
                }
        })
    }

    private fun openProfilePage(profileLoginResponse: ProfileLoginResponse){
        val resultIntent = Intent()
            .putExtra(EXTRA_PROFILE_RESULT, profileLoginResponse)
        setResult(RESULT_CODE, resultIntent)
        finish()
    }
}
