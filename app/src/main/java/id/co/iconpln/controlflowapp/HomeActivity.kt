package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnCalculation.setOnClickListener {

            // navigate to activity main
            val calculationIntent = Intent(this, MainActivity::class.java)
            startActivity(calculationIntent)
        }

        btnClassification.setOnClickListener {

            // Toast
            Toast.makeText(this, "Classification", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
