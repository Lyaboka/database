package com.example.recyclerdb.mydb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MyDBManager(val context: Context) {
    val myDBHelper = MyDBHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDBHelper.writableDatabase
    }

    fun addEmployee(name: String, post: String, salary: Int) {
        val values = ContentValues().apply {
            put(DbNames.NAME_COL, name)
            put(DbNames.POST_COL, post)
            put(DbNames.SALARY_COL, salary)
        }

        db?.insert(DbNames.TABLE_NAME, null, values)
    }

    fun getNamesEmployee(): ArrayList<String> {
        val nameList = ArrayList<String>()
        val cursor = db?.query(DbNames.TABLE_NAME, null, null, null, null, null, null)

            while (cursor?.moveToNext()!!) {
                val dataText = cursor.getString(cursor.getColumnIndexOrThrow(DbNames.NAME_COL))
                nameList.add(dataText.toString())
            }
        cursor.close()
        return nameList
        }
    fun getPostsEmployee(): ArrayList<String> {
        val postList = ArrayList<String>()
        val cursor = db?.query(DbNames.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val dataText = cursor.getString(cursor.getColumnIndexOrThrow(DbNames.POST_COL))
            postList.add(dataText.toString())
        }
        cursor.close()
        return postList
    }
    fun getSalariesEmployee(): ArrayList<Int> {
        val salaryList = ArrayList<Int>()
        val cursor = db?.query(DbNames.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val dataText = cursor.getInt(cursor.getColumnIndexOrThrow(DbNames.SALARY_COL))
            salaryList.add(dataText)
        }
        cursor.close()
        return salaryList
    }


    fun closeDb() {
        myDBHelper.close()
    }
}
