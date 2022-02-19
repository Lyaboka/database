package com.example.recyclerdb

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: EditorActivity, factory: SQLiteDatabase.CursorFactory?) :
SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {



    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE $TABLE_NAME (" +
                "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$NAME_COL TEXT," +
                "$POST_COL TEXT," +
                "$SALARY_COL INTEGER)")
        db.execSQL(query)
    }


    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addEmployee(name : String, post : String, salary : Int) {
        val values = ContentValues()

        values.put(NAME_COL, name)
        values.put(POST_COL, post)
        values.put(SALARY_COL, salary)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }
    fun getEmployee(): Cursor? {
        val db = this.readableDatabase
        return  db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    companion object{
        private const val DATABASE_NAME = "MyDB.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Employees"
        const val ID_COL = "id"
        const val NAME_COL = "name"
        const val POST_COL = "post"
        const val SALARY_COL = "salary"
    }
}