package fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel

import com.google.gson.annotations.SerializedName

data class StuntsCultureItems (
    @SerializedName("version") val version: String ?=null,
   @SerializedName("StuntsCultureItems") val stuntsCultureItems: Array<ItemsType>
)

data class ItemsType(
    @SerializedName("nameItems") val nameItem : String ,
    @SerializedName("TotalPoints") val totalPoints : Int ,
    @SerializedName("skills") val skills : MutableList<Skill>
)

data class Skill(
    @SerializedName("name") val name : String ,
    @SerializedName("points") val points : Int ,
    @SerializedName("VideoID") val videoID : String ,
    @SerializedName("difficulté") val difficulty : String
)


