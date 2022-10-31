package com.example.recycleviewballlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewballlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // create the data source array
    private val ballList = ArrayList<Ball>().apply{
        repeat(6) {
            add(Ball("Baseball",R.drawable.baseball))
            add(Ball("Basketball",R.drawable.basketball))
            add(Ball("Football",R.drawable.football))
            add(Ball("Volleyball",R.drawable.volleyball))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // based on view binding to load the main layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configure the recyclerView
        val layoutManager = LinearLayoutManager(this)
        //val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = BallAdapter(ballList)  //customized your own adapter
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recyclerView.setHasFixedSize(true)

    }

}
