package com.avijitsamanta.recyclerviewmvvm.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.avijitsamanta.recyclerviewmvvm.data.models.UnsplashPhoto
import com.avijitsamanta.recyclerviewmvvm.data.repository.UnsplashPhotoRepository

class UnsplashPhotoViewModel(
    private val repository: UnsplashPhotoRepository
) : ViewModel() {

    fun getPhotos(): LiveData<PagingData<UnsplashPhoto>> {
       return repository.getPhotos().cachedIn(viewModelScope)
    }
}