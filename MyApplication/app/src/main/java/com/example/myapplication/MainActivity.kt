package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG", "Main Activity: onCreate")
        val greetingTextView = findViewById<TextView>(R.id.mob_Namaste)
        val inputField = findViewById<EditText>(R.id.mob_name)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = "" // intialized so that name can be used outside {} of fun.
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == "") {
                Log.i("MYATAG", "Main Activity: +++++++++")
                offersButton.visibility = INVISIBLE // when user enter no name then hide button
                greetingTextView.text = ""
                Toast.makeText(this@MainActivity, "Please Enter a name", Toast.LENGTH_LONG).show()

            } else {
                val message = "Welcome $enteredName"
                Log.i("MYTAG", "Main Activity: $message")
                greetingTextView.text = message
                inputField.text.clear() // text working as extractor (after pressing button, clear the input field)
                offersButton.visibility =
                    VISIBLE // when user enter name then only show visible button
            }
        }
        offersButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG","MainActivity : OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG","MainActivity : OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG","MainActivity : OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG","MainActivity : OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG","MainActivity : OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG","MainActivity : OnRestart")
    }
}



/*In Kotlin, when you define a variable with the val keyword, it means that the variable is a read-only variable
 and its value cannot be changed once it has been assigned.
 However, the object to which the variable refers to can still be mutable.

In this case, the greetingTextView variable is assigned a reference to a TextView object,
and the TextView object has a property named 'text' which can be updated. So,
even though the greetingTextView variable is defined as a val,
we are still able to change the text displayed by the TextView object by using the 'text' property setter. */
