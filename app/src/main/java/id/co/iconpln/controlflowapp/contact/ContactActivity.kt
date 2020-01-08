package id.co.iconpln.controlflowapp.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        initialViewModel()
        showListContact()
        contactViewModel.setContact()
        fetchContactData()
    }

    private fun fetchContactData() {
        contactViewModel.getContact().observe(this, Observer { contactItem ->
            if (contactItem != null){
                adapter.setData(contactItem)
            }
        })
    }

    private fun initialViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ContactViewModel::class.java)
    }

    private fun showListContact() {
        adapter = ContactAdapter()
        adapter.notifyDataSetChanged()
        setupListDivider()

        rvContactList.layoutManager = LinearLayoutManager(this)
        rvContactList.adapter = adapter
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvContactList.context, DividerItemDecoration.VERTICAL )
        rvContactList.addItemDecoration(dividerItemDecoration)
    }
}
