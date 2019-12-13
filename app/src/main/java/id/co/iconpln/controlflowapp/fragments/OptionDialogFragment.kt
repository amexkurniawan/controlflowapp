package id.co.iconpln.controlflowapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_last.*
import kotlinx.android.synthetic.main.fragment_option_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {

    companion object {
        val TAG: String = OptionDialogFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnPilih -> {
                val checkedRadioBtnId: Int = rgDialogOption.checkedRadioButtonId

                if(checkedRadioBtnId != -1){
                    var fvColor = ""

                    when(checkedRadioBtnId) {
                        R.id.rbBlue -> {
                            fvColor = rbBlue.text.toString().trim()
                        }
                        R.id.rbRed -> {
                            fvColor = rbRed.text.toString().trim()
                        }
                        R.id.rbPurple -> {
                            fvColor = rbPurple.text.toString().trim()
                        }
                        R.id.rbGreen -> {
                            fvColor = rbGreen.text.toString().trim()
                        }
                    }
                    Log.d(TAG, "color $fvColor")
                }
            }
            R.id.btnClose -> {
                dialog.cancel()
            }
        }
    }


}
