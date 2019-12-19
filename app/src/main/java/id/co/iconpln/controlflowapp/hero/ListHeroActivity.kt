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

    companion object {
        private const val STATE_TITLE = "state_title"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE ="state_mode"
    }

    private var listHero: ArrayList<Hero> = arrayListOf()
    private var title: String = "Mode List"
    private var mode: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hero)

        mode = R.id.action_hero_list
        setActionBarTitle(title)
        setupListHero()
        showRecyclerList()
        //showRecyclerGrid()

        if (savedInstanceState == null) {
            mode = R.id.action_hero_list
            setActionBarTitle(title)
            listHero.addAll(HeroesData.listDataHero)
            showRecyclerList()
        } else {
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList: ArrayList<Hero>? =
                savedInstanceState.getParcelableArrayList<Hero>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)
            if(stateList != null){
                listHero.addAll(stateList)
            }
            setListMode(stateMode)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putInt(STATE_MODE, mode)
        outState.putParcelableArrayList(STATE_LIST, listHero)
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private fun setupListHero() {
        rvListHero.setHasFixedSize(true)
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

    private fun setListMode(selectedMode: Int) {
        when(selectedMode){
            R.id.action_hero_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_hero_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
        }
        mode = selectedMode
        setActionBarTitle(title)
    }
}
