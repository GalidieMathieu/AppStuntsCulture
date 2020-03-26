package fr.mathieugalidie.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.mathieugalidie.myapplication.JoinUs.JoinUsFragment
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedFragments.SkillsAchived
import fr.mathieugalidie.myapplication.Youtube.youtubeTuto.YoutubeMainFragment
import kotlinx.android.synthetic.main.activity_bottom_nav_stunts.*

class BottomNavTest : AppCompatActivity() {

    private val youtubeFragment: Fragment = YoutubeMainFragment()
    private val joinUsFragment: Fragment = JoinUsFragment()
    private val achievementFragment: Fragment = SkillsAchived()
    private val fm = supportFragmentManager
    private var fragActive = youtubeFragment


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.youtube -> {
                //hide the last fragment and show the fragment we wanna see
                fm.beginTransaction().hide(fragActive).show(youtubeFragment).commit()
                fragActive = youtubeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.join_us -> {
                fm.beginTransaction().hide(fragActive).show(joinUsFragment).commit()
                fragActive = joinUsFragment
                return@OnNavigationItemSelectedListener true
            }

            R.id.trophy -> {
                fm.beginTransaction().hide(fragActive).show(achievementFragment).commit()
                fragActive = achievementFragment

                return@OnNavigationItemSelectedListener true
            }



        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_stunts)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //add fragment in the begining so we save the fragment --> no need to download again images and remeber where was the user

        fm.beginTransaction().add(R.id.content, youtubeFragment, "1").commit()
        fm.beginTransaction().add(R.id.content, joinUsFragment, "2").hide(joinUsFragment).commit()
        fm.beginTransaction().add(R.id.content, achievementFragment, "3").hide(achievementFragment).commit()


    }

}