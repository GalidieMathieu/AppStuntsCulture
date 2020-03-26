package fr.mathieugalidie.myapplication.LoginPage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.BottomNavTest
import fr.mathieugalidie.myapplication.LoginPage.SQL.DataBaseHandler
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login_page.*


class LogInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = DataBaseHandler(context)

        login_button.setOnClickListener{
            val userName : String = user_name.text.toString()
            val password : String = password.text.toString()

            if(db.chekingUser(userName, password))
            {
                val intent = Intent(activity, BottomNavTest::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(context, "Password or UserName wrong",Toast.LENGTH_SHORT).show()
            }

        }
    }
}