package com.pahadi.imgurinsta.ui.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.imgurinsta.data.ImgurRepository
import com.pahadi.libimgur.models.Gallery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    companion object{
        val TAG = "RecStories_d"
    }
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Gallery>>()

    val tags : LiveData<List<Gallery>> = _tags

    fun fetchTags()= viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }
}