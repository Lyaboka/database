package com.example.recyclerdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdb.databinding.RecyclerviewItemBinding
import com.example.recyclerdb.mydb.Employee
import com.example.recyclerdb.mydb.MyDBManager

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>(){

    val employeeList = ArrayList<Employee>()

    class EmployeeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RecyclerviewItemBinding.bind(itemView)

        fun bind(empl: Employee) = with(binding) {
            nameTV.text = empl.name
            postTV.text = empl.post
            salaryTV.text = (empl.salary).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return EmployeeHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    override fun getItemCount() = employeeList.size

    fun addEmployee(empl: Employee) {
        employeeList.add(empl)
        notifyDataSetChanged()
    }
}