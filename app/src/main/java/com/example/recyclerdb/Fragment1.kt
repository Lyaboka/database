package com.example.recyclerdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerdb.databinding.Fragment1Binding
import com.example.recyclerdb.mydb.Employee
import com.example.recyclerdb.mydb.MyDBManager

class Fragment1 : Fragment() {

    val myDBManager = MyDBManager(this.requireContext())
    val adapter = EmployeeAdapter()

    lateinit var employeeList: ArrayList<Employee>
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    private val dataModel : DataModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDBManager.openDb()
        init()
        dataModel.employee.observe(this,{
            employeeList.add(it)
            adapter.addEmployee(it)
        })
        binding.printEmployee.setOnClickListener {
            for (empl in employeeList) {
                adapter.addEmployee(empl)
            }
        }
    binding.buttonSecond.setOnClickListener {

    }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDb()
        _binding = null
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@Fragment1.requireContext())
            recyclerView.adapter = adapter
            employeeList = myDBManager.getEmployee()

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}