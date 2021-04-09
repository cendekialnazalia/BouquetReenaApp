package com.cendekia.bouquetreena

import android.bluetooth.BluetoothDevice.EXTRA_NAME
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PRICE = "extra_price"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTypeBouquet: TextView = findViewById(R.id.tv_item_type)
        val tvNameBouquet: TextView = findViewById(R.id.tv_item_name)
        val tvPriceBouquet: TextView = findViewById(R.id.tv_item_price)

        val type = intent.getStringExtra(EXTRA_TYPE)
        val name = intent.getStringExtra(EXTRA_NAME)
        val price = intent.getStringExtra(EXTRA_PRICE)

        tvTypeBouquet.text = "$type"
        tvNameBouquet.text = "$name"
        tvPriceBouquet.text = "$price"
    }
}