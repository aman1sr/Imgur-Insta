package com.pahadi.imgurinsta.ui.stories

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pahadi.imgurinsta.R
import com.pahadi.imgurinsta.databinding.ListItemStoryHeadBinding
import com.pahadi.libimgur.models.Gallery

class StoriesRecylerAdapter :
    ListAdapter<Gallery, StoriesRecylerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {

        class StoriesViewHolder(val binding: ListItemStoryHeadBinding): RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallBack : DiffUtil.ItemCallback<Gallery>(){
        override fun areItemsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)
        Log.d(StoriesViewModel.TAG, "onBindViewHolder: ")
        holder.binding.storyHeadTextView.text = tag.name
        /*
        * holder.binding.tv = tag.displayName
        * img -> https://i.imgur.com/${tag.backgroundHash}.jpg
        * */

        val imageUrl = "https://i.imgur.com/${tag.topPost?.cover}.jpg"
        holder.binding.storyHeadImageView.load(imageUrl){
            placeholder(R.drawable.placeholder)
            placeholder(R.drawable.placeholder_error)
            
        }
    }


}