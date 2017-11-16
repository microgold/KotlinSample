/**
 * Created by jcity_000 on 11/13/2017.
 */

package com.gdx_example.jcity_000.kotlinsample
import android.os.AsyncTask
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AlphaVantageService() : AsyncTask<String, Void, Float>() {

    constructor(context: ArrayList<Stock>) : this() {
        stocks = context
    }

    private var symbol: String = ""

    override fun doInBackground(vararg symbol: String?): Float {
        this.symbol = symbol[0].toString()

        val price = getPrice(this.symbol)
        return price
    }


    private var urlConnection: HttpURLConnection? = null
    private var stocks: ArrayList<Stock> = ArrayList<Stock>()

    override fun onPostExecute(result: Float) {

        stocks.add(Stock(this.symbol, result!!))
    }

   fun getPrice (symbol : String ): Float {
      val url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=IZ2R2PH0XZ2WPHC2".format(symbol)


      val result = StringBuilder()

      try {

         urlConnection = URL(url).openConnection() as HttpURLConnection
         val `in` = BufferedInputStream(urlConnection!!.getInputStream())
         val reader = BufferedReader(InputStreamReader(`in`))
         var line: String = ""

          while ({ line = reader.readLine(); line }() != null) {
              result.append(line)
          }
//          line = reader.readLine()
//         while (line != null) {
//            result.append(line)
//
//            line = reader.readLine()
//         }

      } catch (e: Exception) {
         e.printStackTrace()
      } finally {
         urlConnection!!.disconnect()
      }

      val message = result.toString()
       val json = JSONObject(message)
       val today = Date()
        var DATE_FORMAT =  SimpleDateFormat("yyyy-MM-dd")
       var dateKey = DATE_FORMAT.format(today) as String
       // get price from today
        val todaysStockPrices = ((json["Time Series (Daily)"] as JSONObject)[dateKey] as JSONObject).getString("4. close")

        return todaysStockPrices.toFloat()


   }


}