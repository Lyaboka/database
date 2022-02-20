package com.example.recyclerdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdb.mydb.MyDBManager

class MainActivity : AppCompatActivity() {
    val myDBManager = MyDBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        myDBManager.openDb()
        val names = myDBManager.getNamesEmployee()
        val posts = myDBManager.getPostsEmployee()
        val salaries = myDBManager.getSalariesEmployee()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(names,posts,salaries)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDBManager.closeDb()
    }

    fun onClickPrint(view: android.view.View) {

        val names = myDBManager.getNamesEmployee()
        val posts = myDBManager.getPostsEmployee()
        val salaries = myDBManager.getSalariesEmployee()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(names,posts,salaries)
    }

    fun onCLickAdd(view: android.view.View) {
        intent = Intent(this,EditorActivity::class.java)
        startActivity(intent)
    }
}