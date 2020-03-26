package fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.main_skills_achieved.*

class SkillsAchived : Fragment()  {


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.main_skills_achieved, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_Tumbling.setOnClickListener {
            val intent = Intent(context, SkillsToAchivedTumbling::class.java)
            intent.putExtra("type_of_skills","Tumbling")
            startActivity(intent)
        }
        button_stunts.setOnClickListener {
            val intent = Intent(context, SkillsToAchived::class.java)
            intent.putExtra("type_of_skills", "Stunts")
            startActivity(intent)
        }
    }

}
