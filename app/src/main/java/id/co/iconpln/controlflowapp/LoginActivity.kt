package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // TODO: 1. Username & password tidak boleh empty.
        // TODO: 2. password minimal 7 digit.
        // TODO: 3. akan sukses jika login: user@mail.com, password
        // TODO: 4. username mengecek format email
    }
}
