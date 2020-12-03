package com.avijitsamanta.recyclerviewmvvm.data.models

data class Photo(
    val id: String,
    val urls: Urls
) {
    data class Urls(
        val full: String?,
        val raw: String?,
        val regular: String?,
        val small: String?,
        val thumb: String?
    )
}