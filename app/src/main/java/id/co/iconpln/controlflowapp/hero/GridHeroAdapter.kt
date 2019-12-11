package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.Hero
import kotlinx.android.synthetic.main.item_grid_hero.view.*

class GridHeroAdapter(val listHero: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridHeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridHeroHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: GridHeroHolder, position: Int) {

    }

    inner class GridHeroHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(hero: Hero) {
            Glide.with(view.context)
                .load(hero.photo)
                .into(view.ivHeroGridPhoto)
        }
    }
}