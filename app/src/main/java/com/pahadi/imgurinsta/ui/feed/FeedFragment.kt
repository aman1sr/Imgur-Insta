package com.pahadi.imgurinsta.ui.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.pahadi.imgurinsta.R
import com.pahadi.imgurinsta.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
        val TAG = "FeedFragment_d"
    }

    private val viewModel: FeedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val feed = arguments?.getString("feed")
        val binding = FragmentFeedBinding.inflate(layoutInflater, container, false)

        feed?.let {
            Log.d(TAG, "FEED Frg:::::::::::...> $it")
            viewModel.updateFeed(it)
        }

        return binding.root
    }


}