package com.example.hungerexpress

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var buttonLogin: CardView
    private lateinit var buttonSignUp: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        etEmail = findViewById(R.id.inputEmail)
        etPassword = findViewById(R.id.inputPassword)
        buttonLogin = findViewById(R.id.btnLogin)
        buttonSignUp = findViewById(R.id.btnSignUp)

        buttonLogin.setOnClickListener {
            if (etEmail.text.toString() == "sp@gmail.com" && etPassword.text.toString() == "Hunger@1") {
                startActivity(Intent(this@LoginActivity, AdminDashboardActivity::class.java))
            } else {
                startActivity(Intent(this@LoginActivity, UserDashboardActivity::class.java))
                finishAffinity()
            }
        }

        buttonSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }

    }
}