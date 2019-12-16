package id.co.iconpln.controlflowapp.fragmentNav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        navViewBottom.setOnNavigationItemSelectedListener()
    }

    private val onNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener
        = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.navigation_home -> return true
                R.id.navigation_person -> return true
            }
            return false
        }
    }
}
