package com.example.recyclerdb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdb.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("Range")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.printEmployee.setOnClickListener {
            val db = MyDBHelper(this,null)

            val cursor = db.getEmployee()
            cursor!!.moveToFirst()
            binding.nameEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.NAME_COL)) + "\n")
            binding.postEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.POST_COL)) + "\n")
            binding.salaryEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.SALARY_COL)) + "\n")
            while(cursor.moveToNext()) {
                binding.nameEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.NAME_COL)) + "\n")
                binding.postEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.POST_COL)) + "\n")
                binding.salaryEmpl.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.SALARY_COL)) + "\n")
            }
            cursor.close()
        }
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}