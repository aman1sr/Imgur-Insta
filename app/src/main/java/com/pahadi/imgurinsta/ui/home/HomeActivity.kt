package com.pahadi.imgurinsta.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.request.ImageRequest
import com.pahadi.imgurinsta.R
import com.pahadi.imgurinsta.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = StoriesRecylerAdapter()
    companion object{
        val TAG = "MainActivity_d"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()

        binding.storiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = storiesAdapter
        }
        storiesViewModel.fetchTags()

    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)       // This line sets up the BottomNavigationView to work with the NavController. It connects the navigation view (navView) to the navigation controller (navController).
    }

    override fun onResume() {
        super.onResume()

/*
* coil preload FAQ -> (https://coil-kt.github.io/coil/getting_started/#preloading)
* */
        storiesViewModel.tags.observe(this){
            it.forEach { tag ->
                val request = ImageRequest.Builder(this)
                    .data("https://i.imgur.com/${tag.backgroundHash}.jpg")
                    .size(resources.getDimensionPixelSize(R.dimen.story_head_image_size))
                    .build()
                Coil.imageLoader(this).enqueue(request)
            }
            storiesAdapter.submitList(it)
        }
    }
}