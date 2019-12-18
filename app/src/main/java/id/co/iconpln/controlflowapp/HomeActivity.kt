package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.bottomSheetDialog.BottomSheetActivity
import id.co.iconpln.controlflowapp.fragmentNav.BottomNavActivity
import id.co.iconpln.controlflowapp.fragmentNavDrawer.NavDrawerActivity
import id.co.iconpln.controlflowapp.fragmentTab.TabActivity
import id.co.iconpln.controlflowapp.fragments.DemoFragmentActivity
import id.co.iconpln.controlflowapp.hero.ListHeroActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setOnClickButton()
    }

    private fun setOnClickButton() {
        
        // onClickListener
        btnCalculation.setOnClickListener(this)
        btnClassification.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnOperation.setOnClickListener(this)
        btnStyle.setOnClickListener(this)
        btnDemo.setOnClickListener(this)
        btnVolume.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnComplexConstraint.setOnClickListener(this)
        btnComplexConstraint2.setOnClickListener(this)
        btnListHero.setOnClickListener(this)
        btnGridHero.setOnClickListener(this)
        btnDemoFragment.setOnClickListener(this)
        btnTab.setOnClickListener(this)
        btnBottomNav.setOnClickListener(this)
        btnNavDrawer.setOnClickListener(this)
        btnBottomSheet.setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btnCalculation -> {
                // navigate to activity main
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }

            R.id.btnClassification -> {
                // navigate to Classification activity
                val classificationIntent = Intent(this, ClassificationActivity::class.java)
                startActivity(classificationIntent)
            }

            R.id.btnLogin -> {
                // navigate to login activity
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }

            R.id.btnOperation -> {
                // navigate to operation activity
                val operationIntent = Intent(this, Operation::class.java)
                startActivity(operationIntent)
            }

            R.id.btnStyle -> {
                // navigate to style activity
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }

            R.id.btnDemo -> {
                // navigate to demo activity
                val demoIntent = Intent(this, DemoActivity::class.java)
                startActivity(demoIntent)
            }

            R.id.btnVolume -> {
                // navigate to volume activity
                val volumeIntent = Intent(this, VolumeActivity::class.java)
                startActivity(volumeIntent)
            }

            R.id.btnIntent -> {
                // navigate to intent activity
                val intent = Intent(this, IntentActivity::class.java)
                startActivity(intent)
            }

            R.id.btnComplexConstraint -> {
                // navigate to ComplexConstraint activity
                val intent = Intent(this, ComplexConstraintActivity::class.java)
                startActivity(intent)
            }

            R.id.btnComplexConstraint2 -> {
                // navigate to ComplexConstraint activity
                val intent = Intent(this, MoreComplexConstraintActivity::class.java)
                startActivity(intent)
            }

            R.id.btnListHero -> {
                // navigate to list hero activity
                val intent = Intent(this, ListHeroActivity::class.java)
                startActivity(intent)
            }

            R.id.btnGridHero -> {
                // navigate to grid hero activity
                val intent = Intent(this, GridHeroActivity::class.java)
                startActivity(intent)
            }

            R.id.btnDemoFragment -> {
                // navigate to demo fragment activity
                val intent = Intent(this, DemoFragmentActivity::class.java)
                startActivity(intent)
            }

            R.id.btnTab -> {
                // navigate to Tab layout
                val intent = Intent(this, TabActivity::class.java)
                startActivity(intent)
            }

            R.id.btnBottomNav -> {
                // navigate to Tab layout
                val intent = Intent(this, BottomNavActivity::class.java)
                startActivity(intent)
            }

            R.id.btnNavDrawer -> {
                val intent = Intent(this, NavDrawerActivity::class.java)
                startActivity(intent)
            }

            R.id.btnBottomSheet -> {
                val bottomSheet = Intent (this, BottomSheetActivity::class.java)
                startActivity(bottomSheet)
            }

        }
    }
}
