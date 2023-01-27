package fr.isen.maignent.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.squareup.picasso.Picasso
import fr.isen.maignent.androidcontactds.databinding.ActivityDetailsContactsBinding
import fr.isen.maignent.androidcontactds.models.Contacts
import fr.isen.maignent.androidcontactds.models.Results

class DetailsContacts : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsContactsBinding
    private lateinit var contact: Contacts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_contacts)
        binding = ActivityDetailsContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contact = intent.getSerializableExtra("contact") as Contacts
        title = contact.name.first + " " + contact.name.last

        binding.name.text = contact.name.first + " " + contact.name.last.uppercase()
        binding.email.text = contact.email
        binding.phone.text = contact.phone
        if (contact.picture.large.isNotEmpty()) {
            Picasso.get().load(contact.picture.large).resize(700, 700).centerCrop().into(binding.photo)
        }
        binding.adresse.text = contact.location.street.name + " " + contact.location.street.number + " \n" + contact.location.city + " " + contact.location.postcode
        binding.birthday.text = contact.dob.date
    }
}