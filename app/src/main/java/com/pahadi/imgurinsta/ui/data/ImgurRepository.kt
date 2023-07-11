package com.pahadi.imgurinsta.ui.data

import com.pahadi.libimgur.ImgurClient
import com.pahadi.libimgur.models.GalleryResponse
import com.pahadi.libimgur.models.GalleryTagResponse
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

}