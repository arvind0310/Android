package com.example.testlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.toasty.Toaster

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnToast)
//        Toaster.simpleToast(this, "hii i am toaster library") // cant access method using direct Class
        val toaster = Toaster()
        button.setOnClickListener {
            toaster.simpleToast(this, "hii i am toaster library")

        }

    }
}