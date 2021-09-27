package com.example.basicloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            var userName = usernameInput.text.toString()
            var userPass = passwordInput.text.toString()

            if (TextUtils.isEmpty(userName)){
                usernameInput.setError("Please enter username....")
            }
            else if (TextUtils.isEmpty(userPass)){
                passwordInput.setError("Please enter password....")
            }else{
                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("user", userName)
                intent.putExtra("password",userPass)

                startActivity(intent)
                finish()
            }
        }
    }
}