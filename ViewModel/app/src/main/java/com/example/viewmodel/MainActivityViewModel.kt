//package com.example.viewmodel
//import android.util.Log
//
//import androidx.lifecycle.ViewModel
//
//class MainActivityViewModel: ViewModel() {
//    var count =0
//    fun upadateCount()
//    {
//        count++
//    }
//
//}


//----------------------------------------------------------------

package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    // var count = 0
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun updateCount(){
        // ++count
        count.value = (count.value)?.plus(1)
    }

}