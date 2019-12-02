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

        if (etLoginUsername.text.isNullOrEmpty() || etLoginPassword.text.isNullOrEmpty()) {
            etLoginUsername.error = "Please insert username"
            etLoginPassword.error = "Please insert password"
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(etLoginUsername.text).matches()){
            etLoginUsername.error = "Invalid e-mail format"
        }
        else if(etLoginPassword.text.length < 7 ) {
            etLoginPassword.error = "Password length must greater or same than 7"
        }
        else if(etLoginUsername.text.toString() != myUsername && etLoginPassword.text.toString() != myPassword) {
            tvLoginStatus.setText("Username or password invalid.")
        }
        else{
            tvLoginStatus.setText("Status login : Successfull")
        }
    }
}
