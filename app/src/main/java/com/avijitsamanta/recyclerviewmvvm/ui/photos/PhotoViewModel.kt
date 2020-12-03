package com.avijitsamanta.recyclerviewmvvm.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avijitsamanta.recyclerviewmvvm.util.MyCoroutines
import com.avijitsamanta.recyclerviewmvvm.data.models.Photo
import com.avijitsamanta.recyclerviewmvvm.data.repository.PhotoRepository
import kotlinx.coroutines.Job

class PhotoViewModel(
    private val repository: PhotoRepository
) : ViewModel() {
    private val _images = MutableLiveData<List<Photo>>()
    private lateinit var job: Job

    val images: LiveData<List<Photo>>
        get() = _images

    fun getPhotos(page: Int) {
        job = MyCoroutines.ioThenMain(
            { repository.getPhotos(page) },
            { list ->
                list?.let {
                    _images.value = it
                }
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}