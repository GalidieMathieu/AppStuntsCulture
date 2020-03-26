package fr.mathieugalidie.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_page.*
import java.io.InputStream

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        var courseAsInputStream : InputStream = resources.openRawResource(R.raw.skills_achived)

        //loading data
        LoadingItems.loadingAllData(true, courseAsInputStream)

        val sharedPref = this?.getSharedPreferences("testBiatch",Context.MODE_PRIVATE) ?: return
        val highScore = sharedPref.getString("test1", "")




        login_button.setOnClickListener{
            val intent = Intent(this, BottomNavTest::class.java)
            startActivity(intent)
        }



    }

}
