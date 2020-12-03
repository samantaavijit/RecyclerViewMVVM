package com.avijitsamanta.recyclerviewmvvm.util

import com.avijitsamanta.recyclerviewmvvm.data.models.Photo

interface PhotoListener {
    fun onPhotoClick(photo: Photo)
}