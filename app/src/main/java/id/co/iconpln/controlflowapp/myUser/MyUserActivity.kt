package id.co.iconpln.controlflowapp.myUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_my_user.*

class MyUserActivity : AppCompatActivity() {

    private lateinit var adapter: MyUserAdapter
    private lateinit var userViewModel: MyUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user)

        initialViewModel()
        showListUser()
        userViewModel.setContact()
        fetchUserData()
    }

    private fun fetchUserData() {
        userViewModel.getContact().observe(this, Observer { userItem ->
            if (userItem != null){
                adapter.setData(userItem)
            }
        })
    }

    private fun initialViewModel() {
        userViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MyUserViewModel::class.java)
    }

    private fun showListUser() {
        adapter = MyUserAdapter()
        adapter.notifyDataSetChanged()
        setupListDivider()

        rvMyUserList.layoutManager = LinearLayoutManager(this)
        rvMyUserList.adapter = adapter
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvMyUserList.context, DividerItemDecoration.VERTICAL )
        rvMyUserList.addItemDecoration(dividerItemDecoration)
    }
}
