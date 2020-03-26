package fr.mathieugalidie.myapplication.FireBase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel.StuntsCultureItems

class FireBaseConnexion {

    val mdatabase = Firebase.database
    val myRef = mdatabase.getReference("StuntsCultureItems")

    private fun test() {
        val userId= myRef.push().key
        myRef.setValue("Hello, World!")



    }




}