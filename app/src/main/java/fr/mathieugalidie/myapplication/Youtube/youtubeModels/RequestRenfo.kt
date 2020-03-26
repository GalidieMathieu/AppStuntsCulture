package fr.mathieugalidie.myapplication.Youtube.youtubeModels

import retrofit2.Call
import retrofit2.http.GET

interface RequestRenfo {

    @GET("playlistItems?part=snippet&maxResults=50&playlistId=PLo4FopmsXov6AG9SU14YWtzR-LZl91gDV&key=AIzaSyApJnpcITcwqYKG7zQ_aqOnLtnGDEXJ76Y")
    fun getAllItems(): Call<YoutubeItems>
}