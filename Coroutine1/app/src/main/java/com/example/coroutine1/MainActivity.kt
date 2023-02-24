package com.example.coroutine1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var count = 0
    /* var downloadView: TextView = findViewById(R.id.tvDownloadBar) // caused app crash */
    lateinit var downloadView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countView = findViewById<TextView>(R.id.tvCount)
        val buttonCount = findViewById<Button>(R.id.btnCount)
        val downloadButton = findViewById<Button>(R.id.btnDownload)
        downloadView = findViewById(R.id.tvDownloadBar)
        buttonCount.setOnClickListener {
            count++
            countView.text = count.toString()
        }
        downloadButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch { // making downloadUserData() as an independent thread.
                downloadUserData()
            }
        }
    }
    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){ // switching coroutine to main thread, cz UI originally belong to main
                downloadView.text = "Downloading user $i"
            }
        }
    }
}
