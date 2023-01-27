package fr.isen.maignent.androidcontactds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

import fr.isen.maignent.androidcontactds.models.Data
import fr.isen.maignent.androidcontactds.models.Results
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(null)

        loadContactsFromAPI()
    }

    private fun loadContactsFromAPI(){
        val jsonObject = JSONObject()
        //Adapter
        val request = JsonObjectRequest(
            Request.Method.GET,
            "https://randomuser.me/api/?results=10&nat=fr",
            jsonObject,
            { response ->
                try {
                    val datas = Gson().fromJson(response.toString(), Results::class.java)
                    recyclerView.adapter = ListAdapter(datas.results) {
                        val intent = Intent(this, DetailsContacts::class.java).putExtra("contact", it)
                        intent.putExtra("contact", it)
                        startActivity(intent)
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        )
        Volley.newRequestQueue(this).add(request)

    }
}