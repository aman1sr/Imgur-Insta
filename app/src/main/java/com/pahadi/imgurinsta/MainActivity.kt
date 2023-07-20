package com.pahadi.imgurinsta

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pahadi.imgurinsta.databinding.ActivityMainBinding
import com.pahadi.imgurinsta.ui.stories.StoriesRecylerAdapter
import com.pahadi.imgurinsta.ui.stories.StoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
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
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()


        storiesViewModel.tags.observe(this){
            storiesAdapter.submitList(it)
        }
    }
}