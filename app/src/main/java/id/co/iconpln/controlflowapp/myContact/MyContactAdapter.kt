package id.co.iconpln.controlflowapp.myContact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.item_list_mycontact.view.*

class MyContactAdapter : RecyclerView.Adapter<MyContactAdapter.MyContactViewHolder>() {
    private val contactData = ArrayList<MyContact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_mycontact, parent, false)
        return MyContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactData.size
    }

    override fun onBindViewHolder(holder: MyContactViewHolder, position: Int) {
        holder.bind(contactData[position])
    }

    fun setData(contactItem: ArrayList<MyContact>){
        contactData.clear()
        contactData.addAll(contactItem)
        notifyDataSetChanged()
    }

    inner class MyContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(contactItem: MyContact) {
            itemView.tvMyContactName.text = contactItem.name
            itemView.tvMyContactEmail.text = contactItem.email
            itemView.tvMyContactMobile.text = contactItem.mobile
        }
    }
}