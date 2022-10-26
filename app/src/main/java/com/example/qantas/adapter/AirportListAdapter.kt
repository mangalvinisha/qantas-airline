package com.example.qantas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qantas.R
import com.example.qantas.listener.OnItemClickListener
import com.example.qantas.model.AirportData
import kotlinx.android.synthetic.main.airport_list_item_view.view.*

class AirportListAdapter(var items: ArrayList<AirportData>, private val context: Context,val listener: OnItemClickListener) :
    RecyclerView.Adapter<AirportListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.airport_list_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAirportName: TextView = view.airportName
        val tvCountryName: TextView = view.countryName
        val ivAirport: ImageView = view.nextBtn
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAirportName.text = items[position].airportName ?: ""
        holder.tvCountryName.text = items[position].country?.countryName ?: ""

        holder.ivAirport.setOnClickListener {
            listener.onListItemClick(items[holder.adapterPosition])
        }
    }
}