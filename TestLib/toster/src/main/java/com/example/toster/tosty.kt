package com.example.toster

import android.content.Context
import android.widget.Toast

class Tosty {
    fun simpleToast(context:Context,msg:String) {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }
}