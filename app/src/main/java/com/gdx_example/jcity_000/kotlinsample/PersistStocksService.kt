package com.gdx_example.jcity_000.kotlinsample

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson


/**
 * Created by jcity_000 on 11/14/2017.
 */
class PersistStocksService {
    fun setStock(ctx: Context, stock: Stock) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(ctx)
        val editor = preferences.edit()
        editor.putString(stock.symbol, Gson().toJson(stock))
        editor.commit()
    }

    fun getStock(ctx: Context, symbol : String): Stock? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(ctx)
        val sobj = preferences.getString(symbol, "")
        return if (sobj == "")
            null
        else
            Gson().fromJson(sobj, Stock::class.java)
    }
}