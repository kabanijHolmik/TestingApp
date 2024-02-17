package com.example.coursework.Util


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.Data.Model.LocalTestEntity
import com.example.coursework.Data.ViewModel.LocalTestViewModel
import com.example.coursework.Data.ViewModel.LocalTestViewModelFactory
import com.example.coursework.R
import com.example.coursework.TestApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var testViewModel: LocalTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
//
//        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
//            (application as TestApplication).repository.insertTest(LocalTestEntity(0, 0, "Udemy Test", "Very special test. Trust me, bro", "programming",
//                dateFormat.parse("2022-12-09")  ,10F ))
//        }


        val recyclerView: RecyclerView = findViewById(R.id.localTestRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val localTestAdapter = LocalTestAdapter()
        recyclerView.adapter = localTestAdapter

        val viewModelFactory = LocalTestViewModelFactory((application as TestApplication).repository)

        testViewModel = ViewModelProvider(this, viewModelFactory)
            .get(LocalTestViewModel::class.java)

        testViewModel.allTests.observe(this, Observer {
            localTests->

            localTestAdapter.setTest(localTests)

        })

    }
}