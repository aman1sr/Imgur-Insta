package com.pahadi.imgurinsta.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.imgurinsta.data.ImgurRepository
import com.pahadi.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    companion object{
        val TAG = "RecStories_d"
    }
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()        // todo: update TAG

    val tags : LiveData<List<Tag>> = _tags

    fun fetchTags()= viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }
}