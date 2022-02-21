package com.example.recyclerdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdb.databinding.ActivityMainBinding
import com.example.recyclerdb.mydb.Employee
import com.example.recyclerdb.mydb.MyDBManager

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val myDBManager = MyDBManager(this)
    val adapter = EmployeeAdapter()
    private var i = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDBManager.openDb()
        init()

        binding.buttonSecond.setOnClickListener {
            intent = Intent(this,EditorActivity::class.java)
            startActivity(intent) }
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            val employeeList = myDBManager.getEmployee()
            printEmployee.setOnClickListener{
                if (i < employeeList.size) {
                    if (employeeList.size - (i) >= 3) {
                        for (c in 1..3) {
                            val employee = employeeList[i]
                            adapter.addEmployee(employee)
                            i++
                        }
                    }
                else {
                        val employee = employeeList[i]
                        adapter.addEmployee(employee)
                        i++
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDb()
    }
}