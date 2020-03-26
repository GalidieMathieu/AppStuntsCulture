package fr.mathieugalidie.myapplication.LoadingItems

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import fr.mathieugalidie.myapplication.Youtube.youtubeModels.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.R
import java.io.ByteArrayOutputStream
import java.io.IOException

import java.io.InputStream
import com.google.gson.Gson
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel.Skill
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel.StuntsCultureItems


//Initiate all items we need for the app

object LoadingItems {

    //--------------------------Declaration For YoutubeItems--------------------------
    val STUNTS: String = "Stunts"
    val TUMBLING: String = "Tumbling"
    val RENFO: String = "Renfo"

    var mYoutubeListTumbling: YoutubeItems? = null
    var mYoutubeListStunts: YoutubeItems? = null
    var mYoutubeListRenfo: YoutubeItems? = null


    var mStuntsCultureItems : StuntsCultureItems ?=null
    var mStuntsCultureItemsSearch: StuntsCultureItems ?=null
    //--------------------------ALL Items--------------------------

    //loading all Items
    fun loadingAllData(isConnected: Boolean, rawRessourceSkills : InputStream) {
        youtubeDataStoring(isConnected)
        skillsAchivedDataStoring(rawRessourceSkills)
    }

    //checking if all items have been created
    fun areItemsCreated():Boolean{
        if(areYoutubeItemsCreated())
            return true

        return false
    }

    //--------------------------Loading all Youtube Items--------------------------
    private fun youtubeDataStoring(connexionStatut: Boolean) {
        //get all item of retrofit

        //getting Stunts items
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RequestAPI::class.java)
        val itemsStunt = retrofit.getAllItems()
        initializeYoutubeList(STUNTS, itemsStunt)

        //getting TUMBLING items
        val retrofit2 = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RequestTumbling::class.java)
        val itemsTumbling = retrofit2.getAllItems()
        initializeYoutubeList(TUMBLING, itemsTumbling)


        //getting STUNTS items
        val retrofit3 = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RequestRenfo::class.java)
        val itemsRenfo = retrofit3.getAllItems()
        initializeYoutubeList(RENFO, itemsRenfo)
    }

    private fun initializeYoutubeList(categorie: String, items: Call<YoutubeItems>) {

        //check if the list was initialized
        //if list == 0, check each item with retrofit
        items.enqueue(object : Callback<YoutubeItems> {
            override fun onFailure(call: Call<YoutubeItems>, t: Throwable) {
                Log.d("YoutubeListIni", "issue in Items.enqueue")
            }

            override fun onResponse(call: Call<YoutubeItems>, response: Response<YoutubeItems>) {

                if (categorie == "Stunts") {
                    mYoutubeListStunts = response.body()
                }
                if (categorie == "Tumbling") {
                    mYoutubeListTumbling = response.body()
                }
                if (categorie == "Renfo") {
                    mYoutubeListRenfo = response.body()
                }

            }

        })


    }

    private fun  areYoutubeItemsCreated():Boolean {
        if(mYoutubeListTumbling!=null && mYoutubeListStunts!=null && mYoutubeListRenfo!=null)
            return true


        return false
    }


    //Loading all SkillsAchievedItems

    private fun skillsAchivedDataStoring( rawRessourceSkills : InputStream){

        val byteArrayOutputStream = ByteArrayOutputStream()
        var i: Int
        try {
            i = rawRessourceSkills.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = rawRessourceSkills.read()
            }
            rawRessourceSkills.close()
        } catch (e: IOException) {

            e.printStackTrace()
        }

        val stuntsCultureItemsAsString = byteArrayOutputStream.toString()
        val gson = Gson()
        mStuntsCultureItems = gson.fromJson(stuntsCultureItemsAsString, StuntsCultureItems::class.java)
        mStuntsCultureItemsSearch = gson.fromJson(stuntsCultureItemsAsString, StuntsCultureItems::class.java)


    }




}