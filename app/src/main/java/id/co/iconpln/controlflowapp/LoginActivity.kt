package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // TODO: 1. Username & password tidak boleh empty.
        // TODO: 2. password minimal 7 digit.
        // TODO: 3. akan sukses jika login: user@mail.com, password
        // TODO: 4. username mengecek format email

        btnLogin.setOnClickListener {
            doLogin()
        }
    }

    fun doLogin(){

        val myUsername: String = "user@mail.com"
        val myPassword: String = "password"

        if(etLoginUsername.text.toString() == myUsername && etLoginPassword.text.toString() == myPassword){
            tvLoginStatus.setText("Status login : Successfull")
        }
        else if (etLoginUsername.text.isNullOrEmpty() || etLoginPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please insert username or password.", Toast.LENGTH_LONG).show()
        }
        else if(etLoginPassword.text.length < 7 ) {
            Toast.makeText(this, "Password length must > 7 !", Toast.LENGTH_LONG).show()
        }
        else {
            tvLoginStatus.setText("Username and password invalid.")
        }
    }
}
