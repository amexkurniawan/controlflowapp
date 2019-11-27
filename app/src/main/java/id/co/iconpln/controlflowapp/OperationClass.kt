package id.co.iconpln.controlflowapp

sealed class OperationClass {
    class Add(val value: Int) : OperationClass()
    class Divide(val value: Int) : OperationClass()
    class Multiply(val value: Int) : OperationClass()
    class Substract(val value: Int) : OperationClass()
}