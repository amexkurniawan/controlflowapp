package id.co.iconpln.controlflowapp.myUserFavorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.database.FavoriteUser
import kotlinx.android.synthetic.main.item_list_myuser.view.*

class MyUserFavoritAdapter()
    : RecyclerView.Adapter<MyUserFavoritAdapter.MyUserFavoritViewHolder>() {

    private var myUsers = emptyList<FavoriteUser>()

    fun setMyUserList(userItems: List<FavoriteUser>) {
        val listFavUser = ArrayList<FavoriteUser>()

        for(i in 0 until userItems.size){
            listFavUser.add(userItems[i])
        }

        myUsers =listFavUser

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserFavoritViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_myuser, parent, false)

        return MyUserFavoritViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myUsers.size
    }

    override fun onBindViewHolder(holder: MyUserFavoritViewHolder, position: Int) {
        holder.bind(myUsers[position])
    }

    inner class MyUserFavoritViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(myUser: FavoriteUser) {
            itemView.tvMyUserName.text = myUser.userName
            itemView.tvMyUserAdress.text = myUser.userAddress
            itemView.tvMyUserMobile.text = myUser.userPhone
        }
    }
}