package id.co.iconpln.controlflowapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.fragments.LastFragment.Companion.message
import kotlinx.android.synthetic.main.fragment_other.*

/**
 * A simple [Fragment] subclass.
 */
class OtherFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLastFragment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnLastFragment -> {
                val fragmentManager: FragmentManager? = fragmentManager
                val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()

                val fragment = LastFragment()

                val bundle: Bundle? = Bundle()
                bundle?.putString(LastFragment.EXTRA_NAME_FRAGMENT, "Hi, ame")
                val hiddenMessage = "My message: this is last message"

                fragment.apply {
                    arguments = bundle
                    message = hiddenMessage
                }

                fragmentTransaction?.replace(R.id.flContainer, fragment)
                fragmentTransaction?.addToBackStack(null)
                fragmentTransaction?.commit()
            }
        }
    }
}
