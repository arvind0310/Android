package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("MYTAG","SecondActivity : OnCreate")
        val textView = findViewById<TextView>(R.id.offerText)
        val userName = intent.getStringExtra("USER")
        val message = "Hey $userName!, you have got an offer of 50% off, when ever you order above 100rs"
        textView.text = message
    }
    

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG","SecondActivity : OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG","SecondActivity : OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG","SecondActivity : OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG","SecondActivity : OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG","SecondActivity : OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG","SecondActivity : OnRestart")
    }
}