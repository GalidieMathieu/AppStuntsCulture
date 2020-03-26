package fr.mathieugalidie.myapplication.LoginPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.fragment_login_page.*

class MainLogInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_login_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_login_button.setOnClickListener{
            (activity as MainActivity).changeFragmentLoginPage("LoginPage")
        }
        main_signIn_button.setOnClickListener{
            (activity as MainActivity).changeFragmentLoginPage("SignInFragment")
        }

    }
}