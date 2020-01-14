package id.co.iconpln.controlflowapp.myUser

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
        const val EXTRA_USER = "EXTRA_USER"
    }

    private lateinit var viewModel: MyUserFormViewModel
    private lateinit var user: UserDataResponse
    private var userId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)
        initIntentExtra()
        initViewModel()
        populateFormData(user)
    }

    private fun initIntentExtra() {
        user = intent.getParcelableExtra(EXTRA_USER) as UserDataResponse
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MyUserFormViewModel::class.java)
    }

    private fun populateFormData(user: UserDataResponse){
        userId = user.id
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
        btnUserFormSave.setOnClickListener(this)
        btnUserFormDelete.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id) {
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
                    deleteUser(id)
                }
            }
        }
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


}
