package com.pahadi.imgurinsta.ui.story

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
import com.pahadi.imgurinsta.databinding.PageItemStoryBinding
import com.pahadi.libimgur.models.Image

class StoryPagerAdapter(): ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallback()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding): RecyclerView.ViewHolder(binding.root)

    class StoryDiffCallback: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater, parent, false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        val image = getItem(position)
        val imgUrl = if (image?.is_album == true && image.images_count != 0) {
            image.images!![0].link
        }else{
            image.link!!
        }
        imgUrl?.let {
            Log.d(StoryActivity.TAG, "Story $position IMGURL: $it")
            holder.binding.storyImageView.load(imgUrl){
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder_error)
            }
            holder.binding.tvStoryText.text = it.toString()
        }

    }


}