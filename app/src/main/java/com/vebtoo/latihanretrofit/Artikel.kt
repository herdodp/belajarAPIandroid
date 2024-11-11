package com.vebtoo.latihanretrofit

data class ArtikelResponse(
    val data: List<Artikel>
)

data class Artikel(
    val juduldb : String,
    val isidb: String
)
