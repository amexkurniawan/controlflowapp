package id.co.iconpln.controlflowapp.hero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
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
        //showRecyclerGrid()

    }

    private fun setupListHero() {
        rvListHero.setHasFixedSize(true)
        listHero.addAll(HeroesData.listDataHero)
        setupListDivider()
    }

    private fun getDataHero(): ArrayList<Hero> {
        var heroName = resources.getStringArray(R.array.hero_name)
        var heroDesc = resources.getStringArray(R.array.hero_description)
        var heroPhoto = resources.getStringArray(R.array.hero_photo)

        val listHero = ArrayList<Hero>()
        for(position in heroName.indices){
            val hero = Hero(
                heroName[position],
                heroDesc[position],
                heroPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun setupListDivider() {
        val dividerItemDecoration = DividerItemDecoration(
            rvListHero.context, DividerItemDecoration.VERTICAL )
        rvListHero.addItemDecoration(dividerItemDecoration)
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

    private fun showRecyclerGrid() {
        rvListHero.layoutManager = GridLayoutManager(this, 3)
        val gridHeroAdapter = GridHeroAdapter(listHero)
        rvListHero.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback{
            override fun onItemClick(hero: Hero) {
                Toast.makeText(this@ListHeroActivity, hero.name, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hero, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setListMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setListMode(mode: Int) {
        when(mode){
            R.id.action_hero_list -> {
                showRecyclerList()
            }
            R.id.action_hero_grid -> {
                showRecyclerGrid()
            }
        }
    }
}
