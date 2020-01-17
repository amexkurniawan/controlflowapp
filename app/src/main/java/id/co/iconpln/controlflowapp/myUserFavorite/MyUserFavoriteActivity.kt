package id.co.iconpln.controlflowapp.myUserFavorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import id.co.iconpln.controlflowapp.myUser.MyUserAdapter
import id.co.iconpln.controlflowapp.myUser.MyUserListener
import id.co.iconpln.controlflowapp.myUser.MyUserViewModel
import id.co.iconpln.controlflowapp.myUserForm.MyUserFormActivity
import kotlinx.android.synthetic.main.activity_my_user_favorite.*

class MyUserFavoriteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: MyUserFavoritAdapter
    private lateinit var viewModel: MyUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_favorite)

        showLoading(true)
        initRecyclerView()
        initViewModel()
        fetchUserList()
        fabMyUserFavoritAdd.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        // reload data after deleted or updated
        fetchUserList()
    }

    private fun initRecyclerView() {
        adapter = MyUserFavoritAdapter(object :
            MyUserFavoritListener {
            override fun onClick(user: UserDataResponse) {
                val intent = Intent(applicationContext, MyUserFormActivity::class.java)
                //intent.putExtra(MyUserFormActivity.EXTRA_USER, user)
                intent.putExtra(MyUserFormActivity.EXTRA_USER_ID, user.id)
                intent.putExtra(MyUserFormActivity.EXTRA_USER_EDIT, true)

                startActivity(intent)
            }
        })

        rvMyUserFavoritList.layoutManager = LinearLayoutManager(this)
        rvMyUserFavoritList.adapter = adapter
    }

    private fun showLoading(state: Boolean){
        if(state){
            pbUserFavorit.visibility = View.VISIBLE
        } else {
            pbUserFavorit.visibility = View.GONE
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
            R.id.fabMyUserFavoritAdd -> {
                startActivity(Intent(this, MyUserFormActivity::class.java))
            }
        }
    }
}
