package com.avijitsamanta.recyclerviewmvvm.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avijitsamanta.recyclerviewmvvm.data.models.Photo
import com.avijitsamanta.recyclerviewmvvm.databinding.PhotoItemBinding
import com.avijitsamanta.recyclerviewmvvm.util.PhotoListener

class PhotosAdapter(
    private val images: List<Photo>,
    private val listener: PhotoListener
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binding.photo = images[position]
        // Enter item
//        holder.binding.root.setOnClickListener {
//
//        }

        holder.binding.imageItem.setOnClickListener {
            listener.onPhotoClick(images[position])
        }
    }

    override fun getItemCount() = images.size

    inner class PhotoViewHolder(val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}