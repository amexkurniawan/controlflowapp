package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import id.co.iconpln.controlflowapp.models.Hero
import id.co.iconpln.controlflowapp.models.HeroesData
import kotlinx.android.synthetic.main.activity_list_hero.*

class GridHeroActivity : AppCompatActivity() {

    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_hero)

        setupGridHero()
    }

    private fun setupGridHero() {
        rvListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
        setupListDivider()
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvListHero.context, DividerItemDecoration.VERTICAL )
        rvListHero.addItemDecoration(dividerItemDecoration)
    }
}
