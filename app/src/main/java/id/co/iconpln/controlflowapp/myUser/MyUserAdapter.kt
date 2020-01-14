package id.co.iconpln.controlflowapp.myUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import kotlinx.android.synthetic.main.item_list_myuser.view.*

class MyUserAdapter : RecyclerView.Adapter<MyUserAdapter.MyUserViewHolder>(){

    private val userData = ArrayList<UserDataResponse>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_myuser, parent, false)
        return MyUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
        holder.bind(userData[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(userData[holder.adapterPosition])
        }
    }

    fun setData(contactItem: ArrayList<UserDataResponse>){
        userData.clear()
        userData.addAll(contactItem)
        notifyDataSetChanged()
    }

    inner class MyUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(userItem: UserDataResponse) {
            itemView.tvUserName.text = userItem.name
            itemView.tvUserAdress.text = userItem.address
            itemView.tvUserMobile.text = userItem.phone
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(userItem: UserDataResponse)
    }
}