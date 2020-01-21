package id.co.iconpln.controlflowapp.myProfileRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_profile_register.*

class MyProfileRegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MyProfileRegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile_register)

        initViewModel()
        clickListener()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MyProfileRegisterViewModel::class.java)
    }

    private fun clickListener(){
        btnProfileReg.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnProfileReg -> {
                Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
