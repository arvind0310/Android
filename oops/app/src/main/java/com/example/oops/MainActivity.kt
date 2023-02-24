package com.example.oops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val car = Car()
        car.start()
        var driver = Driver("Arvind")
        driver.showDetails()
    }
}
