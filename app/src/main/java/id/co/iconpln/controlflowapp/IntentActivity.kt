package id.co.iconpln.controlflowapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.models.Person
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private val REQUEST_CODE = 110

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        setOnClickButton()
    }

    private fun setOnClickButton() {
        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithBundle.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnMoveActivityImplicit.setOnClickListener(this)
        btnMoveActivityWithResult.setOnClickListener(this)
        btnMoveWeb.setOnClickListener(this)
        btnMoveSms.setOnClickListener(this)
        btnMoveShowMap.setOnClickListener(this)
        btnMoveShareText.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.btnMoveActivity -> {
                val intent = Intent(this, StyleActivity::class.java)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithData -> {
                val intent = Intent(this, IntentWithDataActivity::class.java)
                intent.putExtra(IntentWithDataActivity.EXTRA_NAME, "ameks")
                intent.putExtra(IntentWithDataActivity.EXTRA_AGE, 25)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithBundle -> {
                val intent = Intent(this, IntentWithBundleActivity::class.java)
                val bundle = Bundle()
                bundle.putString(IntentWithBundleActivity.EXTRA_BUNDLE_NAME, "ameks bundle")
                bundle.putInt(IntentWithBundleActivity.EXTRA_BUNDLE_AGE, 25)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.btnMoveActivityWithObject -> {
                val person = Person("ameks object",25, "ameks@mail.com", "Yogyakarta")
                val intent = Intent(this, IntentWithObjectActivity::class.java)
                intent.putExtra(IntentWithObjectActivity.EXTRA_PERSON, person)
                startActivity(intent)
            }
            R.id.btnMoveActivityImplicit -> {
                val phoneNumber = "08973331000"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(intent)
            }
            R.id.btnMoveWeb -> {
                val webpage = Uri.parse("https://binar.co.id/")
                val intentWeb = Intent(Intent.ACTION_VIEW, webpage)
                if(intent.resolveActivity(packageManager) != null) {
                    startActivity(intentWeb)
                }
            }
            R.id.btnMoveSms -> {
                val phoneNumber = "089726472412"
                val sendSms = Uri.parse("smsto: $phoneNumber")
                val msg = "Halo, ini Ameks keces"

                val intentSms = Intent(Intent.ACTION_SENDTO, sendSms)
                intentSms.putExtra("sms_body", msg)

                if(intentSms.resolveActivity(packageManager) != null) {
                    startActivity(intentSms)
                }
            }
            R.id.btnMoveShowMap -> {

            }
            R.id.btnMoveShareText -> {

            }
            R.id.btnMoveActivityWithResult -> {
                // IntentResult, give back value for result
                val intent = Intent(this, IntentWithResultActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE) {
            if(resultCode == IntentWithResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(IntentWithResultActivity.EXTRA_VALUE, 0)
                tvIntentResult.text = "Hasil result intent: " + selectedValue.toString()

            }
        }
    }
}
