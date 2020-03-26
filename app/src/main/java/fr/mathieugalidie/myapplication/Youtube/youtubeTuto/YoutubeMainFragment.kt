//main fragment of our youtubeTUto, contain a tabLayout of the differents youtube tutos

package fr.mathieugalidie.myapplication.Youtube.youtubeTuto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import fr.mathieugalidie.myapplication.R

class YoutubeMainFragment : Fragment(){

    private lateinit var viewPager : ViewPager
    private lateinit var tabs : TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.tabs_template, container, false)

        //initialization of our viewPager and tabs
        viewPager = view.findViewById(R.id.viewPager)
        tabs = view.findViewById(R.id.tabLayout)

        val fragmentAdapter = YoutubeTabAdapter(childFragmentManager)//child fragment manager cause its a fragment in a fragment
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        return view
    }
}