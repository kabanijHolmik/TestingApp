package com.example.coursework.Util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.Data.Model.LocalTestEntity
import com.example.coursework.R
import java.sql.Date

class LocalTestAdapter: RecyclerView.Adapter<LocalTestAdapter.LocalTestViewHolder>() {

    var localTests: List<LocalTestEntity> = ArrayList()

    class LocalTestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val testName: TextView = itemView.findViewById(R.id.textViewTestName)
        val testDescription: TextView = itemView.findViewById(R.id.textViewTestDescription)
        val testType: TextView = itemView.findViewById(R.id.textViewTestType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalTestViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.local_test_recycler_view_item, parent, false)

        return LocalTestViewHolder(view)
    }

    override fun getItemCount(): Int {
        return localTests.size
    }

    override fun onBindViewHolder(holder: LocalTestViewHolder, position: Int) {
        var currentTest: LocalTestEntity = localTests[position]

        holder.testName.text = currentTest.testName
        holder.testDescription.text = currentTest.testDescription
        holder.testType.text = currentTest.testType
    }

    fun setTest(localTests: List<LocalTestEntity>){
        this.localTests = localTests
        notifyDataSetChanged()
    }
}