package fr.mathieugalidie.myapplication

import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.Youtube.youtubeTuto.YoutubeMainFragment
import kotlinx.android.synthetic.main.activity_bottom_nav_stunts.*

//TODO change NAV test here

class BottomNavStunts : AppCompatActivity() {
    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.youtube -> {
                val fragment = YoutubeMainFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.join_us -> {
                val fragment = YoutubeMainFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_stunts)


        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = YoutubeMainFragment()
        addFragment(fragment)
    }
}
