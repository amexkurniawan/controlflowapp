package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the widgets
        val textView = findViewById<TextView>(R.id.tvTextHold)
        val button = findViewById<Button>(R.id.btnShow);

        etNilai.setText("100")

        btnShow.setOnClickListener {
            val angka = etNilai.text.toString().toInt()
            hitungPangkat(angka)
        }

        btnShowToast.setOnClickListener {
            Toast.makeText(this, etNilai.text, Toast.LENGTH_LONG).show()
        }
    }

    fun hitungPangkat(nilai: Int) {
        val hitungPangkat = nilai * nilai
        tvTextHold.text = "Hasilnya: $hitungPangkat"
    }
}
