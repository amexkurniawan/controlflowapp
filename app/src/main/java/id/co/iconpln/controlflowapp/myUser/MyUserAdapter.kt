package id.co.iconpln.controlflowapp.myUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import kotlinx.android.synthetic.main.item_list_myuser.view.*

class MyUserAdapter(private val clickListener: MyUserListener)
    : RecyclerView.Adapter<MyUserAdapter.MyUserViewHolder>() {

    private val myUsers = ArrayList<UserDataResponse>()

    fun setMyUserList(listItem: ArrayList<UserDataResponse>) {
        myUsers.clear()
        myUsers.addAll(listItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_myuser, parent, false)

        return MyUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myUsers.size
    }

    override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
        holder.bind(myUsers[position])
    }

    inner class MyUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(myUser: UserDataResponse) {
            itemView.tvMyUserName.text = myUser.name
            itemView.tvMyUserAdress.text = myUser.address
            itemView.tvMyUserMobile.text = myUser.phone
            itemView.setOnClickListener {
                clickListener.onClick(myUser)
            }
        }
    }
}

interface MyUserListener {
    fun onClick(user: UserDataResponse)
}