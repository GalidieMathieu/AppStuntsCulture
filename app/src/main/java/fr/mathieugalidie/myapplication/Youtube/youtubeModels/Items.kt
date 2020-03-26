package fr.mathieugalidie.myapplication.Youtube.youtubeModels

import com.google.gson.annotations.SerializedName


data class YoutubeItems (
    @SerializedName("items") val items: Array<Snippet>
)

data class Snippet(
    @SerializedName("snippet") val snippet : DataItems
)
data class DataItems(
    @SerializedName("title") val title: String,
    @SerializedName("resourceId") val resourceId: ResourceId,
    @SerializedName("thumbnails") val thumbnails: Thumbnails
)

data class ResourceId(
    @SerializedName("videoId") val urlVideo: String
)

data class Thumbnails(
    @SerializedName("medium") val medium: Medium
)

data class Medium(
    @SerializedName("url") val urlImage : String
)

