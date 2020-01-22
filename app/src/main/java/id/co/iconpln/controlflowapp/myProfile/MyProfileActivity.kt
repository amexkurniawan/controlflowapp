package id.co.iconpln.controlflowapp.myProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.myProfileLogin.MyProfileLoginActivity
import kotlinx.android.synthetic.main.activity_my_profile.*

class MyProfileActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        clickListener()
    }

    private fun clickListener(){
        btnProfileToLogin.setOnClickListener(this)
        btnProfileLogout.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){

            R.id.btnProfileToLogin -> {
                val intent = Intent(this, MyProfileLoginActivity::class.java)
                startActivity(intent)
            }
            R.id.btnProfileLogout -> {

            }

        }
    }
}
