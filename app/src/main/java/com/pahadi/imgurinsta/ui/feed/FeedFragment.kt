package com.pahadi.imgurinsta.ui.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.request.ImageRequest
import com.pahadi.imgurinsta.R
import com.pahadi.imgurinsta.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
        val TAG = "FeedFragment_d"
    }

    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter = FeedRecyclerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val feed = arguments?.getString("feed")
        val binding = FragmentFeedBinding.inflate(layoutInflater, container, false)
        binding.rvFeedRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFeedRecylerView.adapter = feedAdapter

        feed?.let {
            Log.d(TAG, "FEED Frg:::::::::::...> $it")
            viewModel.updateFeed(it)
        }

        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
        viewModel.feed.observe(viewLifecycleOwner){
            it.forEach { tag ->
                val request = ImageRequest.Builder(requireActivity())
                    .data("https://i.imgur.com/${tag.cover}.jpg")
                    .size(resources.getDimensionPixelSize(R.dimen.story_head_image_size))
                    .build()
                Coil.imageLoader(requireContext()).enqueue(request)
            }
            feedAdapter.submitList(it)
        }

    }
}