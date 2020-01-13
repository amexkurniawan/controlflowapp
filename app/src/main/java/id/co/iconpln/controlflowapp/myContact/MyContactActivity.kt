package id.co.iconpln.controlflowapp.myContact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_contact.*

class MyContactActivity : AppCompatActivity() {

    private lateinit var adapter: MyContactAdapter
    private lateinit var contactViewModel: MyContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_contact)

        initialViewModel()
        showListContact()

        fetchContactData()
    }

    private fun fetchContactData() {
        contactViewModel.getListContact().observe(this, Observer { contactItem ->
            if (contactItem != null){
                adapter.setData(contactItem)
            }
        })
    }

    private fun initialViewModel() {
        contactViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MyContactViewModel::class.java)
    }

    private fun showListContact() {
        adapter = MyContactAdapter()
        adapter.notifyDataSetChanged()
        setupListDivider()

        rvMyContactList.layoutManager = LinearLayoutManager(this)
        rvMyContactList.adapter = adapter
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvMyContactList.context, DividerItemDecoration.VERTICAL )
        rvMyContactList.addItemDecoration(dividerItemDecoration)
    }
}
