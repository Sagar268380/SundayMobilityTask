package com.elysino.sundaymobilitytask.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.elysino.sundaymobilitytask.R
import com.elysino.sundaymobilitytask.model.Player

class PlayerAdapter1(var context: Context) : RecyclerView.Adapter<PlayerAdapter1.PlayerViewHolder>() {

    var arrayList = ArrayList<Player>()
    fun addItems(arrayList: ArrayList<Player>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.custom_player_list, null, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val (name, captain) = arrayList[position]
        holder.playerName.text = name
        if (captain) {
            holder.relativeLayout.setBackgroundResource(R.drawable.card_bg_back)
        } else {
            holder.relativeLayout.setBackgroundResource(R.drawable.card_bg)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var playerName: TextView = itemView.findViewById(R.id.player_name)
        var relativeLayout: RelativeLayout = itemView.findViewById(R.id.layout)
        var cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}