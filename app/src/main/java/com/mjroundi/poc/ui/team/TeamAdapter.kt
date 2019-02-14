package com.mjroundi.poc.ui.team

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mjroundi.poc.R
import com.mjroundi.poc.models.Trip
import com.squareup.picasso.Picasso

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class TeamAdapter(private val context: Context, private val list: List<Trip>): RecyclerView.Adapter<TeamAdapter
.ListViewHolder>() {
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val trip : Trip = list[position]

        holder.departure.text = trip.departure_place.city_name
        holder.arrival.text = trip.arrival_place.city_name
        holder.price.text = trip.price.string_value
        holder.transferAmount.text = trip.user.display_name

        Picasso.get() // give it the context
                .load(trip.user.picture)
                .into( holder.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.player_layout, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var layout = itemView.findViewById<CardView>(R.id.item_layout)!!
        val departure = itemView.findViewById<TextView>(R.id.name)!!
        val arrival = itemView.findViewById<TextView>(R.id.position)!!
        val price = itemView.findViewById<TextView>(R.id.birth_date)!!
        val transferAmount = itemView.findViewById<TextView>(R.id.transfer_amount)!!
        val photo = itemView.findViewById<ImageView>(R.id.photo)!!
    }
}