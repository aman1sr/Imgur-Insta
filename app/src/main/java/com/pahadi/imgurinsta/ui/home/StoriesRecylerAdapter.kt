package com.pahadi.imgurinsta.ui.home

import android.content.Intent
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
import com.pahadi.imgurinsta.ui.story.StoryActivity
import com.pahadi.libimgur.models.Tag

class StoriesRecylerAdapter :
    ListAdapter<Tag, StoriesRecylerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {

        class StoriesViewHolder(val binding: ListItemStoryHeadBinding): RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallBack : DiffUtil.ItemCallback<Tag>(){
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
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
        Log.d(HomeViewModel.TAG, "onBindViewHolder: ")
        holder.binding.storyHeadTextView.text = tag.displayName
        /*
        * holder.binding.tv = tag.displayName
        * img -> https://i.imgur.com/${tag.backgroundHash}.jpg
        * */

        val imageUrl = "https://i.imgur.com/${tag.backgroundHash}.jpg"
        holder.binding.storyHeadImageView.load(imageUrl){
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder_error)
        }
          // 1st way
     holder.binding.root.apply {
            setOnClickListener {
                context.startActivity(Intent(context,StoryActivity::class.java).apply {
                    putExtra("tag",tag.name)
                })
            }
        }

   /*       // 2nd way
     holder.binding.root.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                p0?.context?.startActivity(Intent(p0?.context,StoryActivity::class.java))
            }
        })
        */
/*NOTE:
* apply() method on a ViewHolder returns a Lazy object, which is a scope function. Scope functions provide a way to run code in a specific context.
* in 2nd way: to pass the context as a parameter to the onClickListener:
*
*
* */

    }


}