package id.co.iconpln.controlflowapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R

class DemoFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_fragment)

        initFragment()
    }

    // init fragment
    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()

        val fragment = HomeFragment()
        fragmentTrasaction.add(R.id.flContainer, fragment)
        fragmentTrasaction.commit()
    }
}
