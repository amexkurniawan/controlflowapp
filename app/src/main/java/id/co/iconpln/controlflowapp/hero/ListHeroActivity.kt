package id.co.iconpln.controlflowapp.hero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.Hero
import id.co.iconpln.controlflowapp.models.HeroesData
import kotlinx.android.synthetic.main.activity_list_hero.*

class ListHeroActivity : AppCompatActivity() {

    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hero)

        setupListHero()
        showRecyclerList()

    }

    private fun setupListHero() {
        rvListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
    }

    private fun showRecyclerList() {
        rvListHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(listHero)
        rvListHero.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, hero.name, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
