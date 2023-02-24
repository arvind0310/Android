package com.example.sharedprefrence

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var nameText: EditText
    lateinit var ageText: EditText
    lateinit var sf: SharedPreferences
    lateinit var editor: SharedPreferences.Editor //instance to edit sf
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        ageText = findViewById(R.id.etAge)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "on-Pause")
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()
        /* store here */
        editor.apply {
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }
    }

    /* when app will start for first time -> create,start, onResume*/
    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "on-Resume")
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age", 0)
        //nameText.text = name -> we did it for TextView prev, here is PlainText
        nameText.setText(name)

        if (age != 0) {
            ageText.setText(age.toString())
        }
    }
}
