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

        setOnClickButton()
    }

    private fun setOnClickButton() {
        
        // onClickListener
        btnCalculation.setOnClickListener(this)
        btnClassification.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnOperation.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btnCalculation -> {
                // navigate to activity main
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }

            R.id.btnClassification -> {
                // navigate to Classification activity
                val classificationIntent = Intent(this, ClassificationActivity::class.java)
                startActivity(classificationIntent)
            }

            R.id.btnLogin -> {
                // navigate to login activity
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }

            R.id.btnOperation -> {
                // navigate to operation activity
                val operationIntent = Intent(this, Operation::class.java)
                startActivity(operationIntent)
            }
        }
    }
}
