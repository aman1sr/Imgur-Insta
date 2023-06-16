package com.pahadi.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data")
    val `data`: List<GalleryResponseData>,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
) {
    @JsonClass(generateAdapter = true)
    data class GalleryResponseData(
        @Json(name = "account_id")
        val accountId: Int,
        @Json(name = "account_url")
        val accountUrl: String,
        @Json(name = "ad_config")
        val adConfig: AdConfig,
        @Json(name = "ad_type")
        val adType: Int,
        @Json(name = "ad_url")
        val adUrl: String,
        @Json(name = "comment_count")
        val commentCount: Int,
        @Json(name = "cover")
        val cover: String,
        @Json(name = "cover_height")
        val coverHeight: Int,
        @Json(name = "cover_width")
        val coverWidth: Int,
        @Json(name = "datetime")
        val datetime: Int,
        @Json(name = "description")
        val description: Any?,
        @Json(name = "downs")
        val downs: Int,
        @Json(name = "favorite")
        val favorite: Boolean,
        @Json(name = "favorite_count")
        val favoriteCount: Int,
        @Json(name = "id")
        val id: String,
        @Json(name = "images")
        val images: List<Image>,
        @Json(name = "images_count")
        val imagesCount: Int,
        @Json(name = "in_gallery")
        val inGallery: Boolean,
        @Json(name = "in_most_viral")
        val inMostViral: Boolean,
        @Json(name = "include_album_ads")
        val includeAlbumAds: Boolean,
        @Json(name = "is_ad")
        val isAd: Boolean,
        @Json(name = "is_album")
        val isAlbum: Boolean,
        @Json(name = "layout")
        val layout: String,
        @Json(name = "link")
        val link: String,
        @Json(name = "nsfw")
        val nsfw: Boolean,
        @Json(name = "points")
        val points: Int,
        @Json(name = "privacy")
        val privacy: String,
        @Json(name = "score")
        val score: Int,
        @Json(name = "section")
        val section: String,
        @Json(name = "tags")
        val tags: List<Tag>,
        @Json(name = "title")
        val title: String,
        @Json(name = "topic")
        val topic: Any?,
        @Json(name = "topic_id")
        val topicId: Any?,
        @Json(name = "ups")
        val ups: Int,
        @Json(name = "views")
        val views: Int,
        @Json(name = "vote")
        val vote: Any?
    ) {
        @JsonClass(generateAdapter = true)
        data class AdConfig(
            @Json(name = "nsfw_score")
            val nsfwScore: Double,

            @Json(name = "showAdLevel")
            val showAdLevel: Int,
            @Json(name = "show_ad_level")
            val show_ad_level: Int,
            @Json(name = "show_ads")
            val showAds: Boolean,
            @Json(name = "showsAds")
            val showsAds: Boolean
        )

    }
}