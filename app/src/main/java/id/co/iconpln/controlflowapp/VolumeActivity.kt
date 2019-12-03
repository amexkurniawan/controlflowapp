package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_volume.*

class VolumeActivity : AppCompatActivity() {

    lateinit var volumeViewModel: VolumeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        initViewModel()
        displayResult()
        setClickListener()
    }

    private fun initViewModel() {
        volumeViewModel = ViewModelProviders.of(this)
            .get(VolumeViewModel::class.java)
    }

    private fun setClickListener() {
        btnCalculate.setOnClickListener {
            val length: String = etVolLength.text.toString()
            val width = etVolWidth.text.toString()
            val height = etVolHeight.text.toString()

            if(length.isEmpty()) {
                etVolLength.error = "Empty field"
            } else if(width.isEmpty()) {
                etVolWidth.error = "Empty field"
            } else if (height.isEmpty()) {
                etVolHeight.error = "Empty field"
            } else {
                volumeViewModel.calculate(length,width,height)
            }

            displayResult()
        }
    }

    private fun displayResult() {
        tvVolResult.text = volumeViewModel.volumeResult.toString()
    }
}
