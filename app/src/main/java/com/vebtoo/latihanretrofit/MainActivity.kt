package com.vebtoo.latihanretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //recyclerview
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)





    //======================================== batas ==============================================
    }
    //======================================== batas ==============================================




    private fun fetchArtikel(){
        ApiClient.instance.getArtikel().enqueue(object: Callback<ArtikelResponse>{
            override fun onResponse(
                call: Call<ArtikelResponse>,
                response: Response<ArtikelResponse>
            ) {
                if(response.isSuccessful){
                    val artikeList = response.body()?.data ?: emptyList()
                    recyclerview.adapter = ArtikelAdapter(artikeList)
                }else{
                    Toast.makeText(this@MainActivity, "gagal mengambil data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArtikelResponse>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
                Toast.makeText(this@MainActivity, "error: ${t.message}'",Toast.LENGTH_SHORT).show()

            }

        })
    }






}