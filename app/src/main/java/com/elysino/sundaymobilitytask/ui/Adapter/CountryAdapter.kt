package com.elysino.sundaymobilitytask.ui.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.elysino.sundaymobilitytask.R
import com.elysino.sundaymobilitytask.model.CountryModel
import com.elysino.sundaymobilitytask.ui.Activity.PlayerListActivity
import java.util.*

class CountryAdapter(var context: Context) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var arrayList = ArrayList<CountryModel?>()
    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    fun addItems(arrayList: ArrayList<CountryModel?>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_data_layout, null, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val countryModel = arrayList[position]

        holder.countryName.text = countryModel?.countryName

        holder.cardView.setOnClickListener {
            val intent = Intent(context, PlayerListActivity::class.java)
            intent.putExtra("player_list", countryModel?.playerLists)
            onItemClickListener?.onClick(intent, false)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView = itemView.findViewById(R.id.country_name)
        var cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    interface OnItemClickListener {
        fun onClick(intent: Intent?, isFinish: Boolean?)
    }

}