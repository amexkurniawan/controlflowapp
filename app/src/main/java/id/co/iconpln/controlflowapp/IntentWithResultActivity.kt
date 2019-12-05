package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_intent_with_result.*

class IntentWithResultActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_VALUE = "extra_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_result)

        onClickListener()
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btnResultChoose) {
            if(rgNumber.checkedRadioButtonId != 0) {
                var value = 0
                when(rgNumber.checkedRadioButtonId) {
                    R.id.rb50 -> value = 50
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb200 -> value = 200
                }
                //Log.d("IntentWithResult", "value: $value")
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }

    fun onClickListener() {
        btnResultChoose.setOnClickListener(this)
    }
}

