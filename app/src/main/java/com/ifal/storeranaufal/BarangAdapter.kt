package com.ifal.storeranaufal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BarangAdapter(val barangList: ArrayList<Barang>): RecyclerView.Adapter<BarangAdapter.BarangHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_barang,parent,false)
        return BarangHolder(itemView)
    }

    override fun getItemCount(): Int {
        return barangList.size
    }

    override fun onBindViewHolder(holder: BarangHolder, position: Int) {
        holder.fnama!!.text = barangList.get(position).nama
        holder.fketerangan!!.text = barangList.get(position).keterangan
        holder.fharga!!.text = "Harga : IDR " +barangList.get(position).harga
        Picasso.get().load(barangList.get(position).gambar).into(holder.fgambar)
        holder.fpromo!!.text = "Promo : IDR " +barangList.get(position).promo


    }

    class BarangHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var fnama: TextView?=itemView.findViewById(R.id.txtNama)
        var fketerangan: TextView?=itemView.findViewById(R.id.txtKeterangan)
        var fharga: TextView?=itemView.findViewById(R.id.txtHarga)
        var fgambar: ImageView?=itemView.findViewById(R.id.imageBarang)
        var fpromo: TextView?=itemView.findViewById(R.id.txtPromo)


    }
}


