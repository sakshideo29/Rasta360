package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class SlideActivity:AppCompatActivity() {
    var viewPager: ViewPager? = null
    private var adapter: SlideViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPager = findViewById(R.id.viewpager)
        adapter = SlideViewAdapter(this)
        viewPager?.adapter = adapter

        if (isOpenAlready()) {
            val intent = Intent(this@SlideActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        } else {
            val editor: SharedPreferences.Editor = getSharedPreferences("slide", MODE_PRIVATE).edit()
            editor.putBoolean("slide", true)
            editor.apply()
        }
    }

    private fun isOpenAlready(): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("slide", MODE_PRIVATE)
        return sharedPreferences.getBoolean("slide", false)
    }

}