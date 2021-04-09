package com.cendekia.bouquetreena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBouquets: RecyclerView
    private var list: ArrayList<Bouquet> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBouquets = findViewById(R.id.rv_bouquets)
        rvBouquets.setHasFixedSize(true)

        list.addAll(BouquetData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBouquets.layoutManager = LinearLayoutManager(this)
        val listBouquetAdapter = ListBouquetAdapter(list)
        rvBouquets.adapter = listBouquetAdapter

        listBouquetAdapter.setOnItemClickCallback(object : ListBouquetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Bouquet) {
                showSelectedBouquet(data)
            }
        })
    }

    private fun showSelectedBouquet(bouquet: Bouquet){
        val moveWithDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TYPE, bouquet.type)
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME, bouquet.name)
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PRICE, bouquet.price)
        startActivity(moveWithDataIntent)
    }

}