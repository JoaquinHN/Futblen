package com.darax.futblen.adapter

import android.content.Context
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darax.futblen.activities.detail.DetailActivity
import com.darax.futblen.model.MatchEvent
import com.darax.futblen.R
import kotlinx.android.synthetic.main.match_item.view.*
import org.jetbrains.anko.intentFor

class TeamsAdapter(private val eventList:List<MatchEvent>, val context: Context): RecyclerView.Adapter<TeamsAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {

        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.match_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event:MatchEvent){
            if(event.intHomeScore == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    itemView.dateScheduleTv.setTextColor(context.getColor(R.color.colorAccent))
                }
            }
            //Aca se usa anko, es una libreria de kotlin que hace mas facil el codigo acortando lineas
            itemView.dateScheduleTv.text = event.dateEvent
            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore




            //https://stackoverflow.com/questions/48741822/unable-to-use-anko-intent-inside-recyclerview-adapter
            itemView.setOnClickListener {
                //Intent.FLAG_ACTIVITY_NEW_TASK
                itemView.context.startActivity(context.intentFor<DetailActivity>("match" to event).addFlags(
                    FLAG_ACTIVITY_NEW_TASK))
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }
    }

}