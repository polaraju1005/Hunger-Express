package com.example.hungerexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonLogin:CardView
    private lateinit var buttonSignUp:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        buttonLogin = findViewById(R.id.btnLogin)
        buttonSignUp = findViewById(R.id.btnSignUp)

        buttonLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity,UserDashboardActivity::class.java))
            finishAffinity()
        }

        buttonSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity,SignUpActivity::class.java))
        }

    }
}