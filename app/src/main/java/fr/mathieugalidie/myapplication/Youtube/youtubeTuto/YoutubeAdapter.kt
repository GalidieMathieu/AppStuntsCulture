//------------------------------------------
//this class is the recycleView of YoutubeListFragment
//we use GLIDE for images
//------------------------------------------


package fr.mathieugalidie.myapplication.Youtube.youtubeTuto


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.mathieugalidie.myapplication.R
import fr.mathieugalidie.myapplication.Youtube.youtubeModels.DataItems
import fr.mathieugalidie.myapplication.Youtube.youtubeModels.YoutubeItems


class YoutubeAdapter(private val list: YoutubeItems?, private val clickListener: (DataItems) -> Unit) : RecyclerView.Adapter<YoutubeViewHolder>() {



    override fun getItemCount(): Int {
        return list?.items!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return YoutubeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        val youtubeItems: DataItems = list!!.items[position].snippet
        //adding item into our recycleView and checking its not null
        if(youtubeItems.title!="Private video") {
            holder.bind(youtubeItems, clickListener)
        }
    }
}

class YoutubeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.youtube_template, parent, false)) {

    //we initialize Text and Image View, ? = can be null
    private var mTitleView: TextView? = null
    private var mImageView: ImageView
    private val mParent = parent
    private var mCard : CardView? = null

    init {
        mTitleView = itemView.findViewById(R.id.youtubeTitle)
        mImageView = itemView.findViewById(R.id.imageYoutube)
        mCard = itemView.findViewById(R.id.youtube_Cardview)
    }

    //use of this function to add item into our recycleView
    fun bind(youtubeItems: DataItems, clickListener: (DataItems) -> Unit) {

        mTitleView?.text = youtubeItems.title
        Glide.with(mParent)
            .load(youtubeItems.thumbnails.medium.urlImage)
            .into(mImageView)

        mCard?.setOnClickListener{clickListener(youtubeItems)}
    }




}

