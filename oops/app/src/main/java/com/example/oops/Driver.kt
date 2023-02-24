package com.example.oops

import android.util.Log

class Driver(name:String) {

   /* driverName = ""
    init{
        driverName = name
    } */
    var driverName:String = name
    fun showDetails()
    {
        Log.i("MYTAG","drive name:$driverName")
    }
}
