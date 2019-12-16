package id.co.iconpln.controlflowapp.fragmentTab

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment as Fragment
    }

    override fun getCount(): Int {
        return 2
    }

}