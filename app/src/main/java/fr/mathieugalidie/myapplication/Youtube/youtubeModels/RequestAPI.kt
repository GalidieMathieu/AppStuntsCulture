package fr.mathieugalidie.myapplication.Youtube.youtubeModels

import retrofit2.Call
import retrofit2.http.GET

interface RequestAPI {

    @GET("playlistItems?part=snippet&maxResults=50&playlistId=PLo4FopmsXov760BmusnJ0ZpPqRzj8FA1K&key=AIzaSyApJnpcITcwqYKG7zQ_aqOnLtnGDEXJ76Y")
    fun getAllItems(): Call<YoutubeItems>


}
