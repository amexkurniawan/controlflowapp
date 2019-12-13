package id.co.iconpln.controlflowapp.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_option_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    companion object {
        val TAG: String = OptionDialogFragment::class.java.simpleName
    }

    private var optionDialogListener: OptionsDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPilih.setOnClickListener(this)
        btnClose.setOnClickListener(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        val parentFragment = parentFragment
        if(parentFragment is LastFragment) {
            val lastFragment = parentFragment

            this.optionDialogListener = lastFragment.optionDialogListener
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnPilih -> {
                val checkedRadioBtnId: Int = rgDialogOption.checkedRadioButtonId

                if(checkedRadioBtnId != -1){
                    var favColor = ""

                    when(checkedRadioBtnId) {
                        R.id.rbBlue -> {
                            favColor = rbBlue.text.toString().trim()
                        }
                        R.id.rbRed -> {
                            favColor = rbRed.text.toString().trim()
                        }
                        R.id.rbPurple -> {
                            favColor = rbPurple.text.toString().trim()
                        }
                        R.id.rbGreen -> {
                            favColor = rbGreen.text.toString().trim()
                        }
                    }
                    Log.d(TAG, "color $favColor")

                    if (optionDialogListener != null){
                        optionDialogListener?.onOptionChoosen(favColor)
                    }
                    dialog.dismiss()

                }
            }
            R.id.btnClose -> {
                dialog.cancel()
            }
        }
    }

    interface OptionsDialogListener {
        fun onOptionChoosen(text: String)
    }


}
