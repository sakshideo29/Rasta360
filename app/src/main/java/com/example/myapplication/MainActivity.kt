package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
        private lateinit var resetpin: TextView
        private lateinit var login: ImageButton


        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                resetpin = findViewById<TextView>(R.id.resetpassword)
                resetpin.setOnClickListener {
                        val intent = Intent(this@MainActivity, resetmpin_activity::class.java)
                        startActivity(intent)
                }

                login=findViewById<ImageButton>(R.id.buttonLogin)
                login.setOnClickListener{
                        val intent = Intent(this@MainActivity, homepage::class.java)
                        startActivity(intent)
                }

        }
}
