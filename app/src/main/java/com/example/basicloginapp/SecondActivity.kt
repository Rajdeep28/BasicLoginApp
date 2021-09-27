package com.example.basicloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var username = intent.getStringExtra("user")
        var password = intent.getStringExtra("password")

        tvWelcome.setText("Welcome ${username}, you entered ${password}")
    }
}