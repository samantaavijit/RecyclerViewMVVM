package com.avijitsamanta.recyclerviewmvvm.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avijitsamanta.recyclerviewmvvm.data.repository.PhotoRepository

@Suppress("UNCHECKED_CAST")
class PhotosViewModelFactory(private val repository: PhotoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotoViewModel(repository) as T
    }

}