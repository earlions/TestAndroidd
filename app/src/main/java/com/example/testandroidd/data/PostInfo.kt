package com.example.testandroidd.data

data class PostInfo(val dataBuy: String, val priceBuy: Int,val dataSale: String, val priceSale: Int, val benefit: Int = priceSale-priceBuy)