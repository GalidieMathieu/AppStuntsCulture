package fr.mathieugalidie.myapplication.LoginPage

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.login_page.*
import java.io.InputStream

class MainActivity : AppCompatActivity() {


    private val fragmentManager = supportFragmentManager
    private val mMainLogInFragment : Fragment = MainLogInFragment()
    private val mLogInFragment: Fragment = LogInFragment()
    private val mSignInFragment: Fragment = SignInFragment()


    private var fragActive = mMainLogInFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)


        //loading data
        var mStuntcultureSkills : InputStream = resources.openRawResource(R.raw.skills_achived)
        LoadingItems.loadingAllData(true, mStuntcultureSkills)


        stunts_Images.setOnClickListener {

            changeFragmentLoginPage("MainLogIn")
        }


        fragmentManager.beginTransaction().add(R.id.frame_login, mMainLogInFragment, "1").commit()
        fragmentManager.beginTransaction().add(R.id.frame_login, mLogInFragment, "2").hide(mLogInFragment).commit()
        fragmentManager.beginTransaction().add(R.id.frame_login, mSignInFragment, "3").hide(mSignInFragment).commit()

    }


    fun changeFragmentLoginPage(namePage : String)
    {
        when(namePage)
        {
            "LoginPage"->{
                fragmentManager.beginTransaction().hide(fragActive).show(mLogInFragment).commit()
                fragActive = mLogInFragment
            }

            "SignInFragment"->{
                fragmentManager.beginTransaction().hide(fragActive).show(mSignInFragment).commit()
                fragActive = mSignInFragment
            }

            "MainLogIn"->{
                fragmentManager.beginTransaction().hide(fragActive).show(mMainLogInFragment).commit()
                fragActive = mMainLogInFragment
            }
        }
    }
}
