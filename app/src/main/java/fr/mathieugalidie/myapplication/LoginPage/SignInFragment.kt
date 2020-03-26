package fr.mathieugalidie.myapplication.LoginPage


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.LoginPage.SQL.DataBaseHandler
import fr.mathieugalidie.myapplication.LoginPage.SQL.User
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_sign_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var db = DataBaseHandler(context)

        signIn_button.setOnClickListener{
            val userName : String = user_name_signIn.text.toString()
            val password : String = password_signIn.text.toString()
            val confirmPass : String = confirm_password.text.toString()



            if(password!=confirmPass)
            {
                Toast.makeText(context, "Password are different",Toast.LENGTH_SHORT).show()
            }
            else{
                var user = User(userName,password)
                db.insertData(user)
                (activity as MainActivity).changeFragmentLoginPage("LoginPage")
            }

        }
    }


}