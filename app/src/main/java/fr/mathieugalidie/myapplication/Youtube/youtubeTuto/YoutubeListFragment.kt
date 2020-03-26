package fr.mathieugalidie.myapplication.Youtube.youtubeTuto

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycle_view_general.*
import android.content.Context
import fr.mathieugalidie.myapplication.LoadingItems.LoadingItems.mYoutubeListTumbling
import fr.mathieugalidie.myapplication.R
import fr.mathieugalidie.myapplication.Youtube.youtubeModels.DataItems


class YoutubeListFragment : Fragment() {

    val YOUTUBE_URL = "video_url"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.recycle_view_general, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_general.apply {

            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            adapter = YoutubeAdapter(mYoutubeListTumbling) { youtubeItems->youtubeItemOnClickListener(youtubeItems)}
        }
    }
    private fun youtubeItemOnClickListener(youtubeItems: DataItems)
    {
        //open a youtubePlayer with the video
        val intent = Intent(activity, YoutubePlayer::class.java)
        intent.putExtra(YOUTUBE_URL, youtubeItems.resourceId.urlVideo)
        startActivity(intent)
    }


}