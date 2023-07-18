package com.pahadi.imgurinsta.data

import com.pahadi.libimgur.ImgurClient
import com.pahadi.libimgur.models.Gallery
import com.pahadi.libimgur.models.Image
import com.pahadi.libimgur.params.Section

class ImgurRepository {
    val api = ImgurClient.api

    suspend fun getHotFeed(): List<Image>? {        // todo: check how return List<Image>?  , changed GalleryResponse Data <-> Image
        val response = api.getGallery(Section.HOT)
        return response?.body()?.data
    }

    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response?.body()?.data
    }

    suspend fun getTags(): List<Gallery>?{
        val response = api.getTags()
        return response.body()?.data?.galleries
    }

}