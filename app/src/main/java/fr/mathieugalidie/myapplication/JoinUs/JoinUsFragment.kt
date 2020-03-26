package fr.mathieugalidie.myapplication.JoinUs

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fr.mathieugalidie.myapplication.BottomNavTest
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.activity_bottom_nav_stunts.*
import kotlinx.android.synthetic.main.join_us_list.*
import kotlinx.android.synthetic.main.join_us_template.*

class JoinUsFragment: Fragment() {

    private val mjoinUsListItem = listOf(
        JoinUsItem("No Contract", "$30", "One Day Access To", "JOIN TODAY", false),
        JoinUsItem("Six Month Contract", "$44", "Unlimited Access To", "JOIN TODAY \n SAVE $120", true),
        JoinUsItem("No Contract", "$49", "Unlimited Access To", "JOIN TODAY", false)
    )



    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.join_us_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        join_us_recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

            adapter = JoinUsAdapterList(mjoinUsListItem){ joinUsItem->JoinUsItemOnClickListener(joinUsItem)}
        }
    }

    private fun JoinUsItemOnClickListener(joinUsItem: JoinUsItem)
    {
        val intent = Intent(activity , WebJoinUs::class.java)
        intent.putExtra("type_abonnement", joinUsItem.price)
        startActivity(intent)
    }

}