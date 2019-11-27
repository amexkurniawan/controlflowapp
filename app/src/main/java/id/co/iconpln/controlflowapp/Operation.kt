package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_operation.*

class Operation : AppCompatActivity(), View.OnClickListener {

    private var inputX: Int = 0
    private var inputY: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        setButtonClickListener()
        getInputNumbers()
    }

    private fun getInputNumbers() {
        if(etBilanganX.text?.isNotEmpty() == true || etBilanganY.text?.isNotEmpty() == true) {
            inputX = etBilanganX.text.toString().toInt()
            inputY = etBilanganY.text.toString().toInt()
        }
    }

    private fun setButtonClickListener() {
        btnAdd.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnAdd -> {
                getInputNumbers()
                tvOperator.text = getString(R.string.operation_add)
                val add = OperationClass.Add(inputX)
                val addResult = execute(inputY, add)
                tbOpResult.text = addResult.toString()

            }
            R.id.btnDiv -> {
                getInputNumbers()
                tvOperator.text = getString(R.string.operation_div)
                val div = OperationClass.Divide(inputX)
                val divResult = execute(inputY, div)
                tbOpResult.text = divResult.toString()
            }
            R.id.btnMult -> {
                getInputNumbers()
                tvOperator.text = getString(R.string.operation_mult)
                val mult = OperationClass.Multiply(inputX)
                val multResult = execute(inputY, mult)
                tbOpResult.text = multResult.toString()
            }
            R.id.btnSub -> {
                getInputNumbers()
                tvOperator.text = getString(R.string.operation_sub)
                val sub = OperationClass.Substract(inputX)
                val subResult = execute(inputY, sub)
                tbOpResult.text = subResult.toString()
            }
            R.id.btnReset -> {
                etBilanganX.setText("")
                etBilanganY.setText("")
                tbOpResult.setText("0")
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
