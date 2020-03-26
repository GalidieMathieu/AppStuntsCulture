package fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedFragments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import fr.mathieugalidie.myapplication.R
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel.Skill

class SkillsAchievedAdapter (private val list: MutableList<Skill>, val context: Context, private val clickListener: (Skill) -> Unit) : RecyclerView.Adapter<SkillsAchivedHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsAchivedHolder {
        val inflater = LayoutInflater.from(context)
        return SkillsAchivedHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SkillsAchivedHolder, position: Int) {
        val skillItem : Skill = list[position]
        holder.bind(skillItem,clickListener )
    }
}


class SkillsAchivedHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_skills_achieved, parent, false)) {

    private var mName: TextView? = null
    private var mPoints: TextView? = null
    private var mDifficulty: TextView? = null
    private var mCardView : CardView?= null

    //initialisation
    init {
        mName = itemView.findViewById(R.id.skills_name)
        mPoints = itemView.findViewById(R.id.number_points_skills)
        mDifficulty = itemView.findViewById(R.id.skills_difficulty)
        mCardView = itemView.findViewById(R.id.skills_Cardview)
    }

    //adding in our recycleView
    fun bind(skill: Skill , clickListener: (Skill) -> Unit) {


        mName?.text = skill.name
        mPoints?.text = skill.points.toString()
        mDifficulty?.text = skill.difficulty

        mCardView?.setOnClickListener{clickListener(skill)}
    }
}