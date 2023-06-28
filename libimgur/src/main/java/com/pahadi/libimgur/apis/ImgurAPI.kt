package com.pahadi.libimgur.apis

import com.pahadi.libimgur.models.GalleryResponse
import com.pahadi.libimgur.models.GalleryTagResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPI {

    @GET("gallery/{section}")      // todo: check the end point 2x
    fun getGallery(
        @Path("section") section : String,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<GalleryTagResponse>


}