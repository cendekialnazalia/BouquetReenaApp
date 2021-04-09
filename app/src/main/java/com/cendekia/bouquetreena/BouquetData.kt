package com.cendekia.bouquetreena

object BouquetData {
    private val bouquetTypes = arrayOf(
        "flower",
        "snack",
        "money",
        "flower",
        "snack",
        "money",
        "flower",
        "skincare",
        "buybuyme",
        "flower")

    private val bouquetNames = arrayOf(
        "Edelweis Flower", "Chopibeng Flower", "Rupiah Purple Flower", "Baby Pink Flower", "Green Laro Flower",
        "Rupiah Pilue Flower", "Pink Rose Flower", "Ponds Mask Flower", "Arbanat Grand Flower", "Artificial Yellow Flower")

    private val bouquetPrices = arrayOf(
        "$14.27", "$10.17", "$20.27", "$17.20", "$8.12", "$24.35", "$15.31", "$11.42", "$10.33","$16.49"
    )

    private val bouquetsImages = intArrayOf(R.drawable.edelweis_bouquet_flower,
        R.drawable.chopibeng_bouquet_flower,
        R.drawable.purple_rupiah_bouquet_flower,
        R.drawable.baby_pink_bouquet_flower,
        R.drawable.green_snack_bouquet_flower,
        R.drawable.pilue_rupiah_bouquet_flower,
        R.drawable.pink_roses_bouquet_flower,
        R.drawable.ponds_mask_bouquet_flower,
        R.drawable.arbanat_bouquet_flower,
        R.drawable.artificial_bouquet_flower)

    val listData: ArrayList<Bouquet>
        get() {
            val list = arrayListOf<Bouquet>()
            for (position in bouquetNames.indices) {
                val bouquet = Bouquet()
                bouquet.type = bouquetTypes[position]
                bouquet.name = bouquetNames[position]
                bouquet.price = bouquetPrices[position]
                bouquet.photo = bouquetsImages[position]
                list.add(bouquet)
            }
            return list
        }

}