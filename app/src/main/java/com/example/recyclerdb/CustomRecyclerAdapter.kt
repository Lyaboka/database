package com.example.recyclerdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdb.mydb.MyDBManager

class CustomRecyclerAdapter
    ( private val names: List<String>,
      private val posts: List<String>,
      private val salaries: List<Int>) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTV: TextView = itemView.findViewById(R.id.nameTV)
        val postTV: TextView = itemView.findViewById(R.id.postTV)
        val salaryTV: TextView = itemView.findViewById(R.id.salaryTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemView = LayoutInflater
          .from(parent.context)
          .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.largeTV.text = names[position]
        holder.postTV.text = posts[position]
        holder.salaryTV.text = (salaries[position]).toString() + " rub"
    }

    override fun getItemCount() = names.size

}