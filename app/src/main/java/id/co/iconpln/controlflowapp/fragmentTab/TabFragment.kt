package id.co.iconpln.controlflowapp.fragmentTab


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_tab.*
import kotlinx.android.synthetic.main.fragment_tab.*

/**
 * A simple [Fragment] subclass.
 */
class TabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTab()
    }

    private fun setupTab() {
        val tabPagerAdapter = TabPagerAdapter(requireContext(), childFragmentManager)
        vpTabFragment.adapter = tabPagerAdapter
        tabFragment.setupWithViewPager((vpTabFragment))
    }

}
