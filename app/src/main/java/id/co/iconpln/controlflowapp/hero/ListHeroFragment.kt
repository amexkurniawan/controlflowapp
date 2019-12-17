package id.co.iconpln.controlflowapp.hero


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.Hero
import id.co.iconpln.controlflowapp.models.HeroesData
import kotlinx.android.synthetic.main.fragment_list_hero.*

/**
 * A simple [Fragment] subclass.
 */
class ListHeroFragment : Fragment() {

    private var listHero: ArrayList<Hero> = arrayListOf()
    lateinit var listHeroAdapter: ListHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_hero, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListHero()
        showRecyclerViewList(view.context)
        setListHeroItemClickListener()
    }

    private fun setupListHero() {
        rvFragmentListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
        setupListDivider()
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvFragmentListHero.context, DividerItemDecoration.VERTICAL )
        rvFragmentListHero.addItemDecoration(dividerItemDecoration)
    }

    private fun showRecyclerViewList(context: Context) {
        rvFragmentListHero.layoutManager = LinearLayoutManager(context)
        listHeroAdapter = ListHeroAdapter(listHero)
        rvFragmentListHero.adapter = listHeroAdapter


    }

    private fun setListHeroItemClickListener(){
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClick(hero: Hero) {
                Toast.makeText(requireContext(), hero.name, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
