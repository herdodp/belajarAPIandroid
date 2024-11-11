package com.vebtoo.latihanretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService{
    @GET("artikel.php") //sesuai dengan endpoint yang digunakan
    fun getArtikel(): Call<ArtikelResponse>
}