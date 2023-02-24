package com.example.toasty

import android.content.Context
import android.widget.Toast

class Toaster {
    fun simpleToast(context: Context,msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }
}

/*
// if you want to use Toaster.simpleToast() without creating an object of Toaster class.

class Toaster {
    companion object {
        fun simpleToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
 */