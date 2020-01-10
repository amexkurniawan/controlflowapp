package id.co.iconpln.controlflowapp.contactFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.contact.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialViewModel()
    }

    private fun initialViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ContactViewModel::class.java)
    }


}
