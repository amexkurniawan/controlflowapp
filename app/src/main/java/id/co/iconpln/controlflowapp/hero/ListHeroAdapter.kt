package id.co.iconpln.controlflowapp.hero

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.models.Hero

class ListHeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}