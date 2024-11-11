package com.vebtoo.latihanretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("artikel.php") //sesuai dengan endpoint yang digunakan
    fun getArtikel(@Query("i") i: Int = 1): Call<ArtikelResponse>
}