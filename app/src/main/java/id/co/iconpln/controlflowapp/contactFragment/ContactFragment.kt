package id.co.iconpln.controlflowapp.contactFragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_contact.*

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    private lateinit var adapter: ContactFragmentAdapter
    private lateinit var contactViewModel: ContactFragmentViewModel

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
        showListContactFragment()
        contactViewModel.setContact()
        showLoading(true)
        fetchContactData()
    }

    private fun initialViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ContactFragmentViewModel::class.java)
    }

    private fun fetchContactData() {
        contactViewModel.getContact().observe(this, Observer { contactFragmentItem ->
            if (contactFragmentItem != null){
                adapter.setData(contactFragmentItem)
                showLoading(false)
            }
        })
    }

    private fun showListContactFragment() {
        adapter = ContactFragmentAdapter()
        adapter.notifyDataSetChanged()
        setupListDivider()

        rvContactFragmentList.layoutManager = LinearLayoutManager(requireContext())
        rvContactFragmentList.adapter = adapter
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvContactFragmentList.context, DividerItemDecoration.VERTICAL )
        rvContactFragmentList.addItemDecoration(dividerItemDecoration)
    }

    private fun showLoading(state: Boolean){
        if(state){
            pbContactFragment.visibility = View.VISIBLE
        } else {
            pbContactFragment.visibility = View.GONE
        }
    }

}
