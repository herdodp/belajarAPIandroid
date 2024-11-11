package com.vebtoo.latihanretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class ArtikelAdapter(private val artikelList: List<Artikel>) : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {

    class ArtikelViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val judul : TextView = view.findViewById(R.id.judul)
        val isi  :TextView = view.findViewById(R.id.isi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artikel, parent, false)
        return ArtikelViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ArtikelViewHolder,
        position: Int,
        //payloads: MutableList<Any>
    ) {
        val artikel = artikelList[position]
        holder.judul.text = artikel.juduldb
        holder.isi.text = artikel.isidb
    }

    override fun getItemCount() = artikelList.size

}