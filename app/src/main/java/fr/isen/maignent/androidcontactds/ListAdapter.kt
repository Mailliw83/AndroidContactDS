package fr.isen.maignent.androidcontactds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.maignent.androidcontactds.models.Contacts
import fr.isen.maignent.androidcontactds.models.Names
import fr.isen.maignent.androidcontactds.models.Results

class ListAdapter(private val contact: Array<Contacts>, val onClick: (Contacts) -> Unit) : RecyclerView.Adapter<ListAdapter.MenuViewHolder>() {
    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView? = view.findViewById(R.id.name)
        val photo: ImageView? = view.findViewById(R.id.photo)
        val adresse: TextView? = view.findViewById(R.id.adresse)
        val email : TextView? = view.findViewById(R.id.email)

        fun bind(contact: Contacts, onClick: (Contacts) -> Unit) {
            name?.text = contact.name.first + " " + contact.name.last.uppercase()
            adresse?.text = contact.location.street.name + " " + contact.location.street.number + " " + contact.location.city + " " + contact.location.postcode
            itemView.setOnClickListener {
                onClick(contact)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cellules_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contact.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(contact[position], onClick)
        if (contact[position].picture.large.isNotEmpty()) {
            Picasso.get().load(contact[position].picture.large).resize(200, 200).centerCrop().into(holder.photo)
        }
        holder.email?.text = contact[position].email

    }
}
