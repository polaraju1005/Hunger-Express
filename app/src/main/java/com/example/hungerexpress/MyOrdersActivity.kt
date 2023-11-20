package com.example.hungerexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import com.google.android.material.textfield.TextInputLayout

class MyOrdersActivity : AppCompatActivity() {

    private lateinit var orderStatus:TextInputLayout
    private lateinit var back:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)

        orderStatus = findViewById(R.id.dropdownOrderStatus)
        back = findViewById(R.id.backButtonIcon)

        back.setOnClickListener {
           val intent = Intent(this@MyOrdersActivity,UserNavigationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        val orderStatuses = resources.getStringArray(R.array.statuses)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, orderStatuses)

        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)

        autocompleteTV.setAdapter(arrayAdapter)
    }
}