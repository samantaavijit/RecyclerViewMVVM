package com.avijitsamanta.recyclerviewmvvm.data.repository

import com.avijitsamanta.recyclerviewmvvm.data.network.PhotoApi

class PhotoRepository(
    private val api: PhotoApi
): SafeApiRequest() {

    suspend fun getPhotos(page:Int)=apiRequest {
        api.getPhotos(page)
    }
}