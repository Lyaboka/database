package com.example.recyclerdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerdb.mydb.Employee

open class DataModel : ViewModel() {
    val employee : MutableLiveData <Employee> by lazy {
        MutableLiveData <Employee>()
    }
}