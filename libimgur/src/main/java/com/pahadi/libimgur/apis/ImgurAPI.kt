package com.pahadi.libimgur.apis

import com.pahadi.libimgur.models.GalleryResponse
import com.pahadi.libimgur.models.GalleryTagResponse
import com.pahadi.libimgur.params.Section
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPI {

    @GET("gallery/{section}")
    fun getGallery(
        @Path("section") section : Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<GalleryTagResponse>


}