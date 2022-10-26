package com.example.qantas.listener

import com.example.qantas.model.AirportData

interface OnItemClickListener {

    /**
     * Handle click event on item click
     */
    fun onListItemClick(item: AirportData?)
}