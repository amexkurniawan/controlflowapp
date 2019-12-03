package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeActivity : AppCompatActivity() {

    private var volumeResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        displayResult()
    }

    private fun displayResult() {
        tvVolResult.text = volumeResult.toString()
    }

    private fun calculate(length: String, width:String, height: String) {
        volumeResult = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height)
    }
}
