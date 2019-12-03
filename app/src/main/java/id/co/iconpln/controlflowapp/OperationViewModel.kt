package id.co.iconpln.controlflowapp

import androidx.lifecycle.ViewModel

class OperationViewModel: ViewModel() {

    var operationResult: Int = 0
    var operator: String = ""

    fun execute(x: Int, operationClass: OperationClass) {
        return when (operationClass) {
            is OperationClass.Add -> {
                operationResult = operationClass.value + x
                operator = "+"
            }
            is OperationClass.Divide -> {
                operationResult = operationClass.value / x
                operator = ":"
            }
            is OperationClass.Multiply -> {
                operationResult = operationClass.value * x
                operator = "*"
            }
            is OperationClass.Substract -> {
                operationResult = operationClass.value - x
                operator = "-"
            }
        }
    }
}