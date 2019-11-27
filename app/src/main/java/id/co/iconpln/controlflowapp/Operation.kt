package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Operation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)
    }

    private fun execute(x: Int, operationClass: OperationClass) : Int {
        return when(operationClass) {
            is OperationClass.Add -> operationClass.value + x
            is OperationClass.Divide -> operationClass.value / x
            is OperationClass.Multiply -> operationClass.value * x
            is OperationClass.Substract -> operationClass.value - x
        }
    }
}
