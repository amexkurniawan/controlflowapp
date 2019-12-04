package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        setOnClickButton()
    }

    private fun setOnClickButton() {
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithBundle.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnMoveActivityWithResult.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.btnMoveActivityWithData -> {
                val intent = Intent(this, IntentWithDataActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithBundle -> {
                val intent = Intent(this, IntentWithBundleActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithObject -> {
                val intent = Intent(this, IntentWithObjectActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithData -> {
                val intent = Intent(this, IntentWithResultActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
