package id.co.iconpln.controlflowapp.myUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user.*

class MyUserActivity : AppCompatActivity() {

    private lateinit var adapter: MyUserAdapter
    private lateinit var viewModel: MyUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user)

        initRecyclerView()
        initViewModel()
        fetchUserList()
    }

    override fun onResume() {
        super.onResume()
        // reload data after deleted or updated
        fetchUserList()
    }

    private fun initRecyclerView() {
        adapter = MyUserAdapter(object: MyUserListener {
            override fun onClick(user: UserDataResponse) {
                val intent = Intent(applicationContext, MyUserFormActivity::class.java)
                intent.putExtra(MyUserFormActivity.EXTRA_USER, user)

                startActivity(intent)
            }
        })

        rvMyUserList.layoutManager = LinearLayoutManager(this)
        rvMyUserList.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)
            .get(MyUserViewModel::class.java)
    }

    private fun fetchUserList() {
        viewModel.getListUsers().observe(this, Observer {
            adapter.setMyUserList(it)
        })
    }

}

