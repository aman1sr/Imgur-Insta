package com.pahadi.libimgur.apis

import com.pahadi.libimgur.models.GalleryResponse
import com.pahadi.libimgur.models.TagResponse
import com.pahadi.libimgur.models.TagsResponse
import com.pahadi.libimgur.params.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPI {
    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path("section") section : Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ): Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

    @GET("gallery/t/{tag}")
    suspend fun getTagGallery(
        @Path("tag") tag: String
    ): Response<TagResponse>

}