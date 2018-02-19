package com.example.air.cryptocurrency.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.air.cryptocurrency.R

class CurrencyHolder internal constructor(itemView: View, callback: RangCallback) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var data_currency = itemView.findViewById<TextView>(R.id.data_currency)
    var data_percent = itemView.findViewById<TextView>(R.id.data_percent)
    var data_price = itemView.findViewById<TextView>(R.id.data_price)

    var callback: RangCallback

    init {
        itemView.setOnClickListener(this)
        this.callback = callback
    }

    fun getContext(): Context {
        return itemView.context
    }

    @SuppressLint("LogNotTimber")
    override fun onClick(v: View?) {
        callback.getPosition(position)
    }

    interface RangCallback{

        fun getPosition(position: Int)

    }

}