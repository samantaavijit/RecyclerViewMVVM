package com.avijitsamanta.recyclerviewmvvm.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.avijitsamanta.recyclerviewmvvm.data.models.UnsplashPhoto
import com.avijitsamanta.recyclerviewmvvm.databinding.UnsplashPhotoItemBinding
import com.avijitsamanta.recyclerviewmvvm.util.PhotoListener

class UnsplashPhotosAdapter(
    private val listener: PhotoListener
) : PagingDataAdapter<UnsplashPhoto, UnsplashPhotosAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            UnsplashPhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.binding.photo = currentItem


        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem == newItem
        }
    }

    inner class PhotoViewHolder(val binding: UnsplashPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root)


}