package com.avijitsamanta.recyclerviewmvvm.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avijitsamanta.recyclerviewmvvm.data.repository.UnsplashPhotoRepository

@Suppress("UNCHECKED_CAST")
class UnsplashPhotosViewModelFactory(private val repository: UnsplashPhotoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UnsplashPhotoViewModel(repository) as T
    }

}