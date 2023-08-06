package com.pahadi.imgurinsta.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.pahadi.imgurinsta.R
import com.pahadi.imgurinsta.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    companion object{
        val TAG = "StoryActivity_d"
    }

    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var binding: ActivityStoryBinding
    private val storyPagerAdapter = StoryPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")
        tagName?.let {
            storyViewModel.fetchTagGallery(it)      // API calling, fetch data of specific story clicked
        }
        binding.storyViewPager.adapter = storyPagerAdapter

        /*
        * so to load the pb once , if wanted to load it for every page shift the View & code to @StoryPagerAdapter  or Below pageChangeCallback code
        * */
//        binding.progressView.animate()
//            .scaleX(1F)
//            .setDuration(5000)
//            .start()

        binding.storyViewPager.registerOnPageChangeCallback(pageChangeCallback)
    }

    /*
    *  create an anonymous object that extends ViewPager2.OnPageChangeCallback().
    * It allows you to define and override the onPageSelected() method (and other methods if needed) directly within the object.
    * This approach is concise and useful when you need to define a simple callback without creating a separate class.
    * */
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)              // will read the position of each page, when slide
            Toast.makeText(this@StoryActivity, "page: $position", Toast.LENGTH_SHORT).show()
            /* will animate each page, if slide new page the animation will reset & start again*/
            binding.progressView.scaleX = 0F
            binding.progressView.animate().cancel()
            binding.progressView.animate()
                .scaleX(1F)
                .setDuration(5000)
                .start()
        }
    }

    override fun onResume() {
        super.onResume()
        storyViewModel.image.observe(this){
            storyPagerAdapter.submitList(it)
            Log.d(TAG, "Story Image List : ${it?.size}")
        }
    }
}