package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_operation.*

class Operation : AppCompatActivity(), View.OnClickListener {

    lateinit var operationViewModel: OperationViewModel
    private var inputX: Int = 0
    private var inputY: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        // init view model
        initViewModel()
        displayResult()
        setButtonClickListener()
        getInputNumbers()
    }

    private fun initViewModel() {
        operationViewModel = ViewModelProviders.of(this)
            .get(OperationViewModel::class.java)
    }

    private fun displayResult() {
        tbOpResult.text = operationViewModel.operationResult.toString()
        tvOperator.text = operationViewModel.operator
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
                var check = checkForError()
                if(check) {
                    getInputNumbers()
                    // operationViewModel.operator = resources.getString(R.string.operation_add)
                    val add = OperationClass.Add(inputX)
                    operationViewModel.execute(inputY, add)
                    displayResult()
                }
            }
            R.id.btnDiv -> {
                var check = checkForError()
                if(check && etBilanganY.text.toString().toInt() != 0) {
                    getInputNumbers()
                    //operationViewModel.operator = resources.getString(R.string.operation_div)
                    val div = OperationClass.Divide(inputX)
                    operationViewModel.execute(inputY, div)
                    displayResult()
                }
            }
            R.id.btnMult -> {
                var check = checkForError()
                if(check) {
                    getInputNumbers()
                    //operationViewModel.operator = resources.getString(R.string.operation_mult)
                    val mult = OperationClass.Multiply(inputX)
                    operationViewModel.execute(inputY, mult)
                    displayResult()
                }
            }
            R.id.btnSub -> {
                var check = checkForError()
                if(check) {
                    getInputNumbers()
                    //operationViewModel.operator = resources.getString(R.string.operation_sub)
                    val sub = OperationClass.Substract(inputX)
                    operationViewModel.execute(inputY, sub)
                    displayResult()
                }
            }
            R.id.btnReset -> {
                etBilanganX.setText("0")
                etBilanganY.setText("0")
                operationViewModel.operationResult = 0
                operationViewModel.operator = ""
                displayResult()
            }
        }
    }

    private fun getInputNumbers() {
        if(etBilanganX.text?.isNotEmpty() == true || etBilanganY.text?.isNotEmpty() == true) {
            inputX = etBilanganX.text.toString().toInt()
            inputY = etBilanganY.text.toString().toInt()
        }
    }

    private fun checkForError(): Boolean {
        if(etBilanganX.text.isNullOrBlank() || etBilanganY.text.isNullOrBlank() || etBilanganX.text.isNullOrEmpty() || etBilanganY.text.isNullOrEmpty()) {
            tbOpResult.text = "Error"
            return false
        }
        else {
            return true
        }
    }
}
