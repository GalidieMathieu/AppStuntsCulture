//Fragment Manager of our youtube Tuotiel TabLayout: allowed us to change fragment with tabs

package fr.mathieugalidie.myapplication.Youtube.youtubeTuto

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class YoutubeTabAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position){
            0->{
                YoutubeListFragment()
            }
            1->YoutubeListFragment2()

            else ->{
                 return YoutubeListFragment3()
            }
        }
    }

    //number of items in the youtube tabs
    override fun getCount(): Int {
        return 3
    }



    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Tumbling"
            1-> "Stunts"
            else->{return "renfo"}
        }
    }


}