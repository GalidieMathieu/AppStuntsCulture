package fr.mathieugalidie.myapplication.Youtube.youtubeModels

import retrofit2.Call
import retrofit2.http.GET

interface RequestTumbling {

    @GET("playlistItems?part=snippet&maxResults=50&playlistId=PLo4FopmsXov6hxC4sdiG6krzskkG7hQXQ&key=AIzaSyApJnpcITcwqYKG7zQ_aqOnLtnGDEXJ76Y")
    fun getAllItems(): Call<YoutubeItems>
}