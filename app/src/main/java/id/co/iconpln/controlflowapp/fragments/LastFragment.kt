package id.co.iconpln.controlflowapp.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.StyleActivity
import kotlinx.android.synthetic.main.fragment_last.*

/**
 * A simple [Fragment] subclass.
 */
class LastFragment : Fragment(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME_FRAGMENT = "extra name fragment"
        var message: String = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnOtherActivity.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name: String? = arguments?.getString(EXTRA_NAME_FRAGMENT)
        tvLastName.text = name
        tvLastMsg.text = message
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnOtherActivity -> {
                val styleIntent = Intent(requireContext(), StyleActivity::class.java)
                startActivity(styleIntent)
            }
        }
    }


}
