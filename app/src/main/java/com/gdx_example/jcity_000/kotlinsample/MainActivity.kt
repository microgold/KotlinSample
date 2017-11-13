package com.gdx_example.jcity_000.kotlinsample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set list view
        setUpListView2()



        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun setUpListView() {
        val listView = findViewById<ListView>(R.id.listView1)

        val values = arrayOf(
                "Rick and Morty",
                "Game of Thrones",
                "Silicon Valley",
                "IT Crowd",
                "Person of Interest")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        listView.adapter =adapter

    }

    fun setUpListView2()
    {
        val stocks = ArrayList<Stock>()
        stocks.add(Stock("IBM", 120.0f))
        stocks.add(Stock("FB", 177.0f))
        stocks.add(Stock("MSFT", 84.0f))
// Create the adapter to convert the array to views
        val adapter = StockAdapter(this, stocks)
// Attach the adapter to a ListView
        val listView = findViewById<ListView>(R.id.listView1)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
