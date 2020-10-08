package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    loadmeme()
    }

    private fun loadmeme(){

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://redd.it/iw95ce"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            Response.Listener { response ->
                // Display the first 500 characters of the response string.
                val url = response.getString("url")
                Glide.with(this).load(url).into(meme_image);

            },
            Response.ErrorListener {
                Toast.makeText(this,"something went wrong",Toast.LENGTH_LONG).show()
            });

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
    fun onNext(view: View) {}
    fun onShare(view: View) {}
}