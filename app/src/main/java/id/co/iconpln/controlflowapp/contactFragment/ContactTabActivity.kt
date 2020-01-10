package id.co.iconpln.controlflowapp.contactFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.fragmentTab.TabPagerAdapter
import kotlinx.android.synthetic.main.activity_contact_tab.*

class ContactTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_tab)

        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = ContactTabAdapter(this, supportFragmentManager)
        vpTabContactFragment.adapter = tabPagerAdapter
        tabContactFragment.setupWithViewPager(vpTabContactFragment)

        supportActionBar?.elevation = 0f
    }
}
