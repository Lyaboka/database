package com.example.recyclerdb.mydb

import android.provider.BaseColumns

object DbNames : BaseColumns {
    const val TABLE_NAME = "employees"
    const val NAME_COL = "name"
    const val POST_COL = "post"
    const val SALARY_COL = "salary"

    const val DATABASE_NAME = "MyDB.db"
    const val DATABASE_VERSION = 1

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
            "${NAME_COL} TEXT," +
            "${POST_COL} TEXT," +
            "${SALARY_COL} INTEGER)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"

}