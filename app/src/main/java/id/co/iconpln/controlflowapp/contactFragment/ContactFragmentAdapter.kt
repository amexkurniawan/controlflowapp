package id.co.iconpln.controlflowapp.contactFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.item_list_contact_fragment.view.*

class ContactFragmentAdapter: RecyclerView.Adapter<ContactFragmentAdapter.ContactFragmentViewHolder>() {

    private val contactData = ArrayList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactFragmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_contact_fragment, parent, false)
        return ContactFragmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactData.size
    }

    override fun onBindViewHolder(holder: ContactFragmentViewHolder, position: Int) {
        holder.bind(contactData[position])
    }

    fun setData(contact: ArrayList<Contact>){
        contactData.clear()
        contactData.addAll(contact)
        notifyDataSetChanged()
    }

    inner class ContactFragmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(contact: Contact) {
            itemView.tvContactFragmentName.text = contact.name
            itemView.tvContactFragmentEmail.text = contact.email
            itemView.tvContactFragmentMobile.text = contact.mobile
        }
    }
}