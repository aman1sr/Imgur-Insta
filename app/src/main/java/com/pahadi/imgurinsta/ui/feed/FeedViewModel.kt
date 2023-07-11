package com.pahadi.imgurinsta.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.imgurinsta.ui.data.ImgurRepository
import com.pahadi.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val repo = ImgurRepository()

    private val _feed = MutableLiveData<List<Image>>()
    val feed: LiveData<List<Image>> = _feed

    fun updateFeed(feedType: String) {
        viewModelScope.launch(Dispatchers.IO){
            when(feedType){
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else -> Log.e(FeedFragment.TAG, "either HOT or TOP: ", )
            }
        }
    }

}