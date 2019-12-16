package id.co.iconpln.controlflowapp.fragmentNavDrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_nav_drawer.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NavDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer)

        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)

        var toogle = ActionBarDrawerToggle(
            this, dlDrawerLayout, toolbar, R.string.app_name, 0
        )

        dlDrawerLayout.addDrawerListener(toogle)
        toogle.syncState()
    }
}
