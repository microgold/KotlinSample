package com.gdx_example.jcity_000.kotlinsample

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jcity_000 on 11/14/2017.
 */
class StockService {

    fun execute(stocks: StockAdapter, symbol: String) {
        val apiKey = "IZ2R2PH0XZ2WPHC2"
        val url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s".format(symbol, apiKey)

        doAsync {
            val result = URL(url).readText()
            val price = getPrice(result)
            uiThread {
                stocks.add(Stock(symbol, price))
                stocks.notifyDataSetChanged()
            }
        }
    }

    fun getPrice(text : String) : Float {
        if (text.trim().length == 0 || ("Invalid" in text)) return -1.0f
        val message = text
        val json = JSONObject(message)
        val today = Date()
        var DATE_FORMAT =  SimpleDateFormat("yyyy-MM-dd")
        var dateKey = DATE_FORMAT.format(today) as String
        // get price from today
        val todaysStockPrices = ((json["Time Series (Daily)"] as JSONObject)[dateKey] as JSONObject).getString("4. close")

        return todaysStockPrices.toFloat()

    }
}