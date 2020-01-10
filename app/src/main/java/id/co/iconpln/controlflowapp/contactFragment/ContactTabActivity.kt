package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R

class ContactTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_tab)

        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()

        val fragment = ContactFragment()
        fragmentTrasaction.add(R.id.flContainer, fragment)
        fragmentTrasaction.commit()
    }
}
