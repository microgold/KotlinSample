package com.gdx_example.jcity_000.kotlinsample


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Stock
{
    var symbol : String = ""
    var price : Float = 0.0f

     constructor(symbol1: String, price1 : Float){
        symbol = symbol1
        price = price1
    }
}

/**
 * Created by jcity_000 on 11/12/2017.
 */
class StockAdapter(context: Context, stocks: ArrayList<Stock>) : ArrayAdapter<Stock>(context, 0, stocks) {

    val items = stocks

    fun getAllStocks() : ArrayList<Stock> {
        return items
    }

    override fun getView(position: Int, convertView1: View?, parent: ViewGroup): View {
        var convertView = convertView1
        // Get the data item for this position
        val stock = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_stock, parent, false)
        }
        // Lookup view for data population
        val tvSymbol = convertView!!.findViewById<TextView>(R.id.tvSymbol)
        val tvPrice = convertView!!.findViewById<TextView>(R.id.tvPrice)
        // Populate the data into the template view using the data object
        tvSymbol.setText(stock!!.symbol)
        if (stock!!.price < 0)
            tvPrice.setText("n/a")
        else
            tvPrice.setText(stock!!.price.toString())
        // Return the completed view to render on screen
        return convertView
    }

    override fun getItem(position: Int): Stock {
        return super.getItem(position)
    }


}