package com.pahadi.imgurinsta.ui.feed

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pahadi.imgurinsta.databinding.ListItemGalleryImageBinding
import com.pahadi.libimgur.models.Image

class FeedRecyclerAdapter :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    companion object{
        val TAG = "RecyclerAdapter_d"
    }
        class FeedViewHolder(val binding: ListItemGalleryImageBinding): RecyclerView.ViewHolder(binding.root)
    private class FeedDiffCallBack: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.textView.text = image.title.toString()

        image.cover.toString().let {
            val imgLink : String = "https://i.imgur.com/${it}.jpg"
            holder.binding.imageView.load(imgLink)
            Log.d(TAG, "pos:$position>> IMG: $imgLink")
        }


    }


}