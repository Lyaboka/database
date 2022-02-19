package com.example.recyclerdb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditorActivity : AppCompatActivity() {
    private lateinit var nameET : EditText
    private lateinit var postET : EditText
    private lateinit var salaryET : EditText
    private lateinit var addEmployee : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        initView()
        addEmployee.setOnClickListener {
            val db = MyDBHelper(this,null)

            val name = nameET.text.toString()
            val post = postET.text.toString()
            val salary = (salaryET.text.toString()).toInt()

            db.addEmployee(name,post,salary)
            Toast.makeText(this, "$name added to database!", Toast.LENGTH_LONG)

            nameET.text.clear()
            postET.text.clear()
            salaryET.text.clear()
        }
    }
    private fun initView() {
        nameET = findViewById(R.id.nameET)
        postET = findViewById(R.id.postET)
        salaryET = findViewById(R.id.salaryET)
        addEmployee = findViewById(R.id.addEmployee)
    }



}