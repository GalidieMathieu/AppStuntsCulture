package fr.mathieugalidie.myapplication.Youtube.youtubeTuto

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.youtube_player.*

class YoutubePlayer : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private var mVideoID:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.youtube_player)
        youtube_player.initialize("AIzaSyApJnpcITcwqYKG7zQ_aqOnLtnGDEXJ76Y",this)
        mVideoID = intent.getStringExtra("video_url")

    }


        override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, p2: Boolean) {
            if(!p2)
            {
                youTubePlayer?.cueVideo(mVideoID)
                youTubePlayer?.setFullscreen(true)
            }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
    }
}