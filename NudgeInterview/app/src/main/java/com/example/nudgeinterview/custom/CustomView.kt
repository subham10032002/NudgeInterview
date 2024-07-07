package com.example.nudgeinterview.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nudgeinterview.R

class CustomView(context: Context, attrs: AttributeSet?= null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var recyclerView: RecyclerView

    private val adapter = DataAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this, true)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

    }

    fun appendChildrenToRecyclerView() {

        adapter.clearData()

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            adapter.addChildView(childView)
        }
    }

    fun setData(data: List<String>) {
        adapter.setData(data)
    }

}