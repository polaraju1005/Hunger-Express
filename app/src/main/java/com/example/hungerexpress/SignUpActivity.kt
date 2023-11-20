package com.example.hungerexpress

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private lateinit var buttonSignUp: CardView
    private lateinit var textGotoLogin: TextView
    private lateinit var textAddAddress: TextView

    private lateinit var inputLayoutAdd1: TextInputLayout
    private lateinit var inputLayoutAdd2: TextInputLayout
    private lateinit var inputLayoutCity: TextInputLayout
    private lateinit var inputLayoutState: TextInputLayout
    private lateinit var inputLayoutZipCode: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        buttonSignUp = findViewById(R.id.btnSignUp)
        textGotoLogin = findViewById(R.id.txtGotoLoginPage)
        textAddAddress = findViewById(R.id.txtAddAddress)

        inputLayoutAdd1 = findViewById(R.id.textInputLayoutAdd1)
        inputLayoutAdd2 = findViewById(R.id.textInputLayoutAdd2)
        inputLayoutCity = findViewById(R.id.textInputLayoutCity)
        inputLayoutState = findViewById(R.id.textInputLayoutState)
        inputLayoutZipCode = findViewById(R.id.textInputLayoutZipCode)

        buttonSignUp.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }

        textGotoLogin.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
        }

        textAddAddress.setOnClickListener {
            inputLayoutAdd1.isVisible = true
            inputLayoutAdd2.isVisible = true
            inputLayoutCity.isVisible = true
            inputLayoutState.isVisible = true
            inputLayoutZipCode.isVisible = true
        }
    }
}