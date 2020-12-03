package com.avijitsamanta.recyclerviewmvvm.util

import com.avijitsamanta.recyclerviewmvvm.data.models.UnsplashPhoto

interface PhotoListener {
    fun onPhotoClick(photo: UnsplashPhoto)
}