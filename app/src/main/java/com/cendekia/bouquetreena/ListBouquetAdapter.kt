package com.cendekia.bouquetreena

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBouquetAdapter (val listBouquet: ArrayList<Bouquet>) : RecyclerView.Adapter<ListBouquetAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvType : TextView = itemView.findViewById(R.id.tv_item_type)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvPrice : TextView = itemView.findViewById(R.id.tv_item_price)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_bouquet, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBouquet.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val bouquet = listBouquet[position]
        Glide.with(holder.itemView.context)
            .load(bouquet.photo)
            .apply(RequestOptions().override(3005, 3005))
            .into(holder.imgPhoto)
        holder.tvType.text = bouquet.type
        holder.tvName.text = bouquet.name
        holder.tvPrice.text = bouquet.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBouquet[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Bouquet)
    }
}