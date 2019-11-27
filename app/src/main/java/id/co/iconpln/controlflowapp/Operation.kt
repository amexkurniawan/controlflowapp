package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_operation.*

class Operation : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        btnAdd.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnOperation.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnAdd -> {

            }

            R.id.btnDiv -> {

            }

            R.id.btnMult -> {

            }

            R.id.btnSub -> {

            }

            R.id.btnOperation -> {
                
            }
        }
    }

    private fun execute(x: Int, operationClass: OperationClass): Int {
        return when (operationClass) {
            is OperationClass.Add -> operationClass.value + x
            is OperationClass.Divide -> operationClass.value / x
            is OperationClass.Multiply -> operationClass.value * x
            is OperationClass.Substract -> operationClass.value - x
        }
    }
}
