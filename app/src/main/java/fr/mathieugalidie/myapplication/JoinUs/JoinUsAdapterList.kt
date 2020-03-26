package fr.mathieugalidie.myapplication.JoinUs

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import fr.mathieugalidie.myapplication.R

class JoinUsAdapterList(private val list: List<JoinUsItem>, private val clickListener: (JoinUsItem) -> Unit) : RecyclerView.Adapter<JoinUsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoinUsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JoinUsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: JoinUsViewHolder, position: Int) {
        val joinUsItem : JoinUsItem = list[position]
        holder.bind(joinUsItem,clickListener )
    }
}


class JoinUsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.join_us_template, parent, false)) {

    private var mTitle: TextView? = null
    private var m_JoinUsButton: Button? = null
    private var m_layoutForm: LinearLayout? = null
    private var mPrice: TextView? = null
    private var mAccess: TextView? = null

    //initialisation
    init {
        mTitle = itemView.findViewById(R.id.title_joinUS)
        m_JoinUsButton = itemView.findViewById(R.id.join_us_button)

        m_layoutForm = itemView.findViewById(R.id.layout_joinUS)
        mPrice = itemView.findViewById(R.id.price)
        mAccess = itemView.findViewById(R.id.access)
    }

    //adding in our recycleView
    fun bind(joinUsItem: JoinUsItem , clickListener: (JoinUsItem) -> Unit) {

        if (joinUsItem.isGreen) {
            //TODO CHANGE TO setTextColor(ContextCompat.getColor(Context, R.color.greenStunts))
            mTitle?.setTextColor(Color.parseColor("#54C775"))
            m_JoinUsButton?.setBackgroundResource(R.drawable.button_green_white)
            m_layoutForm?.setBackgroundResource(R.drawable.layout_green_black)
            m_JoinUsButton?.text = joinUsItem.textButton
        }

        mTitle?.text = joinUsItem.title
        mAccess?.text = joinUsItem.access
        mPrice?.text = joinUsItem.price

        m_JoinUsButton?.setOnClickListener{clickListener(joinUsItem)}
    }
}