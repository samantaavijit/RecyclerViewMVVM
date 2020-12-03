package com.avijitsamanta.recyclerviewmvvm.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.avijitsamanta.recyclerviewmvvm.data.network.UnsplashPhotoApi
import com.avijitsamanta.recyclerviewmvvm.data.paging.UnsplashPagingSource

class UnsplashPhotoRepository(
    private val api: UnsplashPhotoApi
) {
    fun getPhotos() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { UnsplashPagingSource(api) }
    ).liveData
}