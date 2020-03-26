package fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedFragments

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems.mStuntsCultureItems
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems.mStuntsCultureItemsSearch
import fr.mathieugalidie.myapplication.R
import fr.mathieugalidie.myapplication.SkillsAchieved.SkillsAchievedModel.Skill
import kotlinx.android.synthetic.main.recycle_view_general.*
import kotlinx.android.synthetic.main.recycle_view_skills.*

class SkillsToAchived : AppCompatActivity() {


    var list: MutableList<Skill> = mStuntsCultureItems!!.stuntsCultureItems[1].skills
    var displayList: MutableList<Skill> = mStuntsCultureItemsSearch!!.stuntsCultureItems[1].skills

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_view_skills)

        // set a LinearLayoutManager to handle Android
        // RecyclerView behavior

        recyclerView_skills.layoutManager = LinearLayoutManager(this)
        // set the custom adapter to the RecyclerView
        recyclerView_skills.adapter = SkillsAchievedAdapter(displayList, this) {}
        //list de data skills
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {


        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.search_stunt)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    if (p0!!.isNotEmpty()) {


                        displayList.clear()

                        val search = p0.toLowerCase()

                        for(skill in list)
                        {
                            if (skill.name.toLowerCase().contains(search))
                                displayList.add(skill)
                        }


                        recyclerView_skills.adapter!!.notifyDataSetChanged()

                    }
                    else {
                        displayList.clear()
                        displayList.addAll(list)
                        recyclerView_skills.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}