package com.example.recyclerdb.mydb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MyDBManager(val context: Context) {

    val employeeList = ArrayList<Employee>()
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

    fun getEmployee(): ArrayList<Employee> {

        val cursor = db?.query(DbNames.TABLE_NAME, null, null, null, null, null, null)

            while (cursor?.moveToNext()!!) {
                val name = cursor.getString(cursor.getColumnIndexOrThrow(DbNames.NAME_COL))
                val post = cursor.getString(cursor.getColumnIndexOrThrow(DbNames.POST_COL))
                val salary = cursor.getInt(cursor.getColumnIndexOrThrow(DbNames.SALARY_COL))
                employeeList.add(Employee(name, post, salary))
            }
        cursor.close()
        return employeeList
        }



    fun closeDb() {
        myDBHelper.close()
    }
}
