package id.co.iconpln.controlflowapp.myUserForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user_form.*

class MyUserFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER = "user"
        const val EXTRA_USER_EDIT = "edit"
        const val EXTRA_USER_ID ="id"
    }

    private lateinit var user: UserDataResponse
    private lateinit var viewModel: MyUserFormViewModel
    private var userId: Int? = null
    private var isEditUser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)

        setClickButton()
        getIntentExtra()
        initViewModel()
        cekForm(isEditUser)
    }

    private fun setClickButton() {
        btnUserFormAdd.setOnClickListener(this)
        btnUserFormSave.setOnClickListener(this)
        btnUserFormDelete.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnUserFormAdd -> {
                val newUserData = UserDataResponse(
                    etUserFormAddress.text.toString(),
                    0,
                    etUserFormName.text.toString(),
                    etUserFormHp.text.toString()
                )

                pbUserForm.visibility = View.VISIBLE
                createUser(newUserData)
            }
            R.id.btnUserFormSave -> {
                userId?.let { id ->
                    val updateUserData = UserDataResponse(
                        etUserFormAddress.text.toString(),
                        id,
                        etUserFormName.text.toString(),
                        etUserFormHp.text.toString()
                    )

                    updateUser(id, updateUserData)
                }
            }
            R.id.btnUserFormDelete -> {
                userId?.let { id ->
                    pbUserForm.visibility = View.VISIBLE
                    deleteUser(id)
                }
            }
        }
    }

    private fun getUser(userId: Int){
        viewModel.getUser(userId).observe(this, Observer { userDataReponse ->
            if(userDataReponse != null){
                Toast.makeText(this, "User loaded successfull!", Toast.LENGTH_SHORT).show()
                populateFormData(userDataReponse)
                pbUserForm.visibility = View.GONE
                llMyUserFormLoading.visibility = View.VISIBLE
            }
        })
    }

    private fun fetchUserData() {
        pbUserForm.visibility = View.VISIBLE
        llMyUserFormLoading.visibility = View.GONE
        getUser(userId as Int)
    }

    private fun createUser(newUserData: UserDataResponse) {
        viewModel.createUser(newUserData).observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, "Successfully Added!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to add", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteUser(id: Int) {
        viewModel.deleteUser(id).observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, "Successfully Deleted!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to delete", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateUser(id: Int, userData: UserDataResponse) {
        viewModel.updateUser(id, userData).observe(this, Observer { userDataReponse ->

            if (userDataReponse != null) {
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to update", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getIntentExtra() {
        userId = intent.getIntExtra(EXTRA_USER_ID, 0)
//        if(intent.hasExtra(EXTRA_USER)){
//            user = intent.getParcelableExtra(EXTRA_USER) as UserDataResponse
//        } else {
//            user = UserDataResponse("", 0, "", "")
//        }
        isEditUser = intent.getBooleanExtra(EXTRA_USER_EDIT, false)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MyUserFormViewModel::class.java)
    }

    private fun cekForm(editUser : Boolean) {
        if(editUser){
            fetchUserData()
            //populateFormData(user)
            //btnUserFormSave.visibility = View.VISIBLE
            //btnUserFormDelete.visibility = View.VISIBLE
            //btnUserFormAdd.visibility = View.GONE
        } else {
            btnUserFormSave.visibility = View.GONE
            btnUserFormDelete.visibility = View.GONE
            btnUserFormAdd.visibility = View.VISIBLE
        }
    }

    private fun populateFormData(user: UserDataResponse) {
        userId = user.id
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
    }


}
