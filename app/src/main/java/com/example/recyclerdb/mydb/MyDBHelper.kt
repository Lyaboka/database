package com.example.recyclerdb.mydb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper(context: Context) :
SQLiteOpenHelper(context, DbNames.DATABASE_NAME, null, DbNames.DATABASE_VERSION) {



    override fun onCreate(db: SQLiteDatabase) {
        db?.execSQL(DbNames.CREATE_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db?.execSQL(DbNames.DELETE_TABLE)
        onCreate(db)
    }




}