package com.katherineryn.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            val moveToMain = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(moveToMain)
            finish()
        }, 1500)
    }
}