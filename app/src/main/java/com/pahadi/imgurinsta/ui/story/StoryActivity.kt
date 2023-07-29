package com.pahadi.imgurinsta.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
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

    }

    override fun onResume() {
        super.onResume()
        storyViewModel.image.observe(this){
            storyPagerAdapter.submitList(it)
            Log.d(TAG, "Story Image List : ${it?.size}")
        }
    }
}