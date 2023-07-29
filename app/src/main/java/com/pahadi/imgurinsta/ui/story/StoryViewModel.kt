package com.pahadi.imgurinsta.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.imgurinsta.data.ImgurRepository
import com.pahadi.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel : ViewModel() {
    private val repo = ImgurRepository()

    private val _image = MutableLiveData<List<Image>?>()
    val image : LiveData<List<Image>?>  = _image

    fun fetchTagGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _image.postValue(repo.getTagGallery(tagName))
    }
}