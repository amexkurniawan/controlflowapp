package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_with_data.*

class IntentWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_data)

        getIntentExtra()
        showData()
    }

    private fun showData() {
        val str = "Intent with data, name: $name, age: $age"
        tvDataReceived.text = str
    }

    private fun getIntentExtra() {
        name = intent.getStringExtra(IntentWithDataActivity.EXTRA_NAME)
        age = intent.getIntExtra(IntentWithDataActivity.EXTRA_AGE, 0)
    }
}
