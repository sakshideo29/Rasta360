package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class splash_activity : AppCompatActivity(){
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Add any initialization or setup code here

        // Example: Redirect to the main activity after a delay
        android.os.Handler().postDelayed({
            val intent: Intent = Intent(this@splash_activity, SlideActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000 milliseconds (2 seconds) delay
    }

}