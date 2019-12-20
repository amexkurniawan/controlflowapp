package id.co.iconpln.controlflowapp.fragmentViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_scroll.*

class ScrollActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        setupSlideView()
    }

    private fun setupSlideView() {
        val pagerAdapter = ScrollPagerAdapter(supportFragmentManager)
        vpScroll.adapter = pagerAdapter
        //tabScrollIndicator.setupWithViewPager(vpScroll)
        pageIndicatorScroll.setViewPager(vpScroll)
    }

    override fun onBackPressed() {
        if(vpScroll.currentItem == 0) {
            super.onBackPressed()
        } else {
            vpScroll.currentItem = vpScroll.currentItem - 1
        }
    }
}
