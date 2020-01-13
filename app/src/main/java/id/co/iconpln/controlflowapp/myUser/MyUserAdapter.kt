package id.co.iconpln.controlflowapp.myUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.item_list_myuser.view.*

class MyUserAdapter : RecyclerView.Adapter<MyUserAdapter.MyUserViewHolder>(){

    private val userData = ArrayList<MyUser>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_myuser, parent, false)
        return MyUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
        holder.bind(userData[position])
    }

    fun setData(contactItem: ArrayList<MyUser>){
        userData.clear()
        userData.addAll(contactItem)
        notifyDataSetChanged()
    }

    inner class MyUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(userItem: MyUser) {
            itemView.tvUserName.text = userItem.name
            itemView.tvUserAdress.text = userItem.address
            itemView.tvUserMobile.text = userItem.mobile
        }
    }
}