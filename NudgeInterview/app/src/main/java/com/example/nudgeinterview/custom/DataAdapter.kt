package com.example.nudgeinterview.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nudgeinterview.R

class DataAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private var dataList: List<String> = emptyList()

    private val childViews = mutableListOf<View>()

    fun setData(data: List<String>) {
        dataList = data
        notifyDataSetChanged()
    }

    fun addChildView(view: View) {
        childViews.add(view)
        notifyItemInserted(childViews.size - 1)
    }

    fun clearData() {
        childViews.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        if (position < childViews.size) {
            val childView = childViews[position]
            holder.bindChildView(childView)
        } else {
            val dataItem = dataList[position - childViews.size]
            holder.bindData(dataItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size + childViews.size
    }

}

class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(dataItem: String) {
        itemView.findViewById<TextView>(R.id.textData).text = dataItem
    }

    fun bindChildView(childView: View) {
        val container = itemView.findViewById<FrameLayout>(R.id.childContainer)
        container.removeAllViews()
        container.addView(childView)
    }
}