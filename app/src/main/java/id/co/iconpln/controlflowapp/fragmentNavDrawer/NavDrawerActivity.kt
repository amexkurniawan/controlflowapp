package id.co.iconpln.controlflowapp.fragmentNavDrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)

        setupActionBar()
        navViewDrawer.setNavigationItemSelectedListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)

        var toogle = ActionBarDrawerToggle(
            this, dlDrawerLayout, toolbar, R.string.app_name, 0
        )

        dlDrawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home_drawer -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_person_drawer -> {
                Toast.makeText(this, "Person", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gelery_drawer -> {
                Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show()
            }
        }


        title = item.title// item title in actionbar
        
        dlDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
