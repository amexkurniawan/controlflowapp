package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.Hero
import kotlinx.android.synthetic.main.item_list_hero.view.*

class ListHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(listHero[position], position)
    }

    inner class HeroViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun  bind(hero: Hero, position:Int) {
            view.tvListTitle.text = hero.name
            view.tvListDescription.text = hero.desc
            Glide.with(view.context)
                .load(hero.photo)
                .into(view.ivListImage)
        }
    }
}