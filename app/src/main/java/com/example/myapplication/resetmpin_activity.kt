package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class resetmpin_activity: AppCompatActivity() {
    private lateinit var loginarraw: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mobileverification)

        // Finding the ImageButton from the layout after setting the content view
        loginarraw = findViewById(R.id.loginarraw)

        // Setting OnClickListener for the ImageButton
        loginarraw.setOnClickListener {
            val intent = Intent(this@resetmpin_activity, homepage::class.java)
            startActivity(intent)
        }
    }
}
