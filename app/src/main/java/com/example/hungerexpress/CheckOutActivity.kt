package com.example.hungerexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import com.google.android.material.textfield.TextInputLayout

class CheckOutActivity : AppCompatActivity() {

    private lateinit var dropdownSavedAdds:TextInputLayout
    private lateinit var dropdownPay:TextInputLayout
    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        dropdownSavedAdds = findViewById(R.id.dropdownSavedAdds)
        dropdownPay = findViewById(R.id.dropdownPayMethods)
        back = findViewById(R.id.backButtonIcon)

        back.setOnClickListener {
            val intent = Intent(this@CheckOutActivity,UserDashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        val savedAdds = resources.getStringArray(R.array.addresses)
        val payMethods = resources.getStringArray(R.array.payMethods)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, savedAdds)
        val arrayAdapter2 = ArrayAdapter(this,R.layout.dropdown_item,payMethods)

        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        val autocompleteTV2 = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView3)

        autocompleteTV.setAdapter(arrayAdapter)
        autocompleteTV2.setAdapter(arrayAdapter2)
    }
}