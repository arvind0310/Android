//package com.example.viewmodel
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.TextView
//import androidx.lifecycle.ViewModelProvider
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.i("MYTAG", "Main Activity: onCreate")
//        var count = 0
//        var viewModel: MainActivityViewModel =
//            ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        val buttonCount = findViewById<Button>(R.id.btnCount)
//        val showResult = findViewById<TextView>(R.id.tvCount)
//        val buttonReset = findViewById<Button>(R.id.btnReset)
//        /*showResult.text = count.toString() */
//        showResult.text = viewModel.count.toString()
//        buttonCount.setOnClickListener {
//            /* count++ // int  -> do not save data*/
//            /* (viewModel.count)++ */
//            viewModel.upadateCount()
//            showResult.text = viewModel.count.toString()
//        }
//        buttonReset.setOnClickListener {
//            viewModel.count = 0
//            showResult.text = viewModel.count.toString()
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.i("MYTAG", "MainActivity : OnStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.i("MYTAG", "MainActivity : OnResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i("MYTAG", "MainActivity : OnPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.i("MYTAG", "MainActivity : OnStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.i("MYTAG", "MainActivity : OnDestroy")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.i("MYTAG", "MainActivity : OnRestart")
//    }
//}


//----------------------------------------------------------------------

package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.R

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)

        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        button.setOnClickListener {
            viewModel.updateCount()
        /*as we are observing count hence whenever count changes,
            go to where observe is applied and execute code that if it has count dependency
 */
        }

    }
}
