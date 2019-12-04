package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_with_bundle.*

class IntentWithBundleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BUNDLE_NAME = "extra_bundle_name"
        const val EXTRA_BUNDLE_AGE = "extra_bundle_age"
    }

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_bundle)

        getIntentExtra()
        showData()
    }

    private fun showData() {
        var str = "Intent with data, name: $name, age: $age"
        tvDataReceivedBundle.text = str
    }

    private fun getIntentExtra() {
        val bundle = intent.extras
        //name = intent.extras?.getString(EXTRA_BUNDLE_NAME) ?: ""
        //age = intent.extras?.getInt(EXTRA_BUNDLE_AGE) ?: 0
        name = bundle?.getString(EXTRA_BUNDLE_NAME) ?: ""
        age = bundle?.getInt(EXTRA_BUNDLE_AGE) ?: 0
    }
}
