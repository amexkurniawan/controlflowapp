package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_classification.*

class ClassificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classification)

        etClassificationNilai.setText("0")

        btnClassificationShow.setOnClickListener {
            if(etClassificationNilai.text.isNullOrEmpty()) {
                Toast.makeText(this, "Empty value !", Toast.LENGTH_LONG).show()
            }
            else {
                doClassification(etClassificationNilai.text.toString().toInt())
            }
        }
    }

    fun doClassification(nilai: Int) {

        var result = "";

        when(nilai) {
            in 0..70 -> result = "Hasilnya Anda Tidak Lulus!"
            in 71..80 -> result = "Hasilnya Anda Lulus!"
            in 81..100 -> result = "Hasilnya Anda Lulus Banget!"
            in 101..1000 -> result = "Not support value!"
            else -> Toast.makeText(this, "Not support value!", Toast.LENGTH_LONG).show()
        }

        tvClassificationText.text = result
    }
}
