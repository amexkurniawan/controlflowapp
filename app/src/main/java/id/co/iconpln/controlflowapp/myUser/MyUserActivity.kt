package id.co.iconpln.controlflowapp.myUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.myUserForm.MyUserFormActivity
import kotlinx.android.synthetic.main.activity_my_user.*

class MyUserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: MyUserAdapter
    private lateinit var viewModel: MyUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user)

        showLoading(true)
        initRecyclerView()
        initViewModel()
        fetchUserList()
        fabMyUserAdd.setOnClickListener(this)
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
                //intent.putExtra(MyUserFormActivity.EXTRA_USER, user)
                intent.putExtra(MyUserFormActivity.EXTRA_USER_ID, user.id)
                intent.putExtra(MyUserFormActivity.EXTRA_USER_EDIT, true)

                startActivity(intent)
            }
        })

        rvMyUserList.layoutManager = LinearLayoutManager(this)
        rvMyUserList.adapter = adapter
    }

    private fun showLoading(state: Boolean){
        if(state){
            pbUserProgressForm.visibility = View.VISIBLE
        } else {
            pbUserProgressForm.visibility = View.GONE
        }
    }

    private fun initViewModel() {
        //pbUserProgressForm.visibility = View.VISIBLE
        viewModel = ViewModelProviders.of(this)
            .get(MyUserViewModel::class.java)
    }

    private fun fetchUserList() {
        viewModel.getListUsers().observe(this, Observer {
            adapter.setMyUserList(it)
            showLoading(false)
        })
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.fabMyUserAdd -> {
                startActivity(Intent(this, MyUserFormActivity::class.java))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorit_myuser, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_list_favorit -> {
                startActivity(Intent(this, MyUserFavoriteActivity::class.java))
                true
            }
            else -> true
        }
    }

}

