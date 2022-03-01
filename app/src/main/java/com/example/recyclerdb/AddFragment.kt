package com.example.recyclerdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.recyclerdb.databinding.FragmentAddBinding
import com.example.recyclerdb.mydb.Employee
import com.example.recyclerdb.mydb.MyDBManager

class AddFragment : Fragment() {
    lateinit var binding : FragmentAddBinding

    private val dataModel : DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addEmployee.setOnClickListener {
            val myDBManager = MyDBManager(this.requireContext())

            val name = binding.nameET.text.toString()
            val post = binding.postET.text.toString()
            val salary = (binding.salaryET.text.toString()).toInt()
            myDBManager.openDb()
            myDBManager.addEmployee(name,post,salary)
            dataModel.employee.value = Employee(name, post, salary)
            Toast.makeText(this.requireContext(), "$name added to database!", Toast.LENGTH_LONG).show()

            binding.nameET.text.clear()
            binding.postET.text.clear()
            binding.salaryET.text.clear()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddFragment()
    }
}