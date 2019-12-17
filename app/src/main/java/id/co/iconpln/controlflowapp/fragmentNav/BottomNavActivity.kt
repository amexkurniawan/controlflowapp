package id.co.iconpln.controlflowapp.fragmentNav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.fragmentTab.FirstFragment
import id.co.iconpln.controlflowapp.fragmentTab.SecondFragment
import id.co.iconpln.controlflowapp.hero.ListHeroFragment
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        navViewBottom.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navViewBottom.selectedItemId = R.id.navigation_home // default nav
    }

    private val onNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener
        = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.navigation_home -> {
                    loadFragment(FirstFragment())
                    return true
                }
                R.id.navigation_person -> {
                    loadFragment(ListHeroFragment())
                    return true
                }
            }
            return false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment, fragment::class.java.simpleName)
            .commit()
    }
}
