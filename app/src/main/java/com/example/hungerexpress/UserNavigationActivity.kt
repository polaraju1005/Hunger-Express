package com.example.hungerexpress

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView


class UserNavigationActivity : AppCompatActivity() {

    private lateinit var buttonLogout:CardView
    private lateinit var backButton:ImageView
    private lateinit var textMyOrders: TextView
    private lateinit var changePass:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_navigation)

        buttonLogout = findViewById(R.id.btnLogout)
        backButton = findViewById(R.id.backButtonIcon)
        textMyOrders = findViewById(R.id.txtMyOrders)
        changePass = findViewById(R.id.txtChangePass)

        backButton.setOnClickListener {
            val intent = Intent(this, UserDashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
        }

        textMyOrders.setOnClickListener {
            startActivity(Intent(this@UserNavigationActivity,MyOrdersActivity::class.java))
        }

        changePass.setOnClickListener {
            showChangePasswordDialog()
        }

        buttonLogout.setOnClickListener {
            startActivity(Intent(this@UserNavigationActivity,LoginActivity::class.java))
            finishAffinity()
        }
    }

    private fun showChangePasswordDialog() {
        val passDialog = Dialog(this)
        passDialog.setContentView(R.layout.change_password_dialog)
        passDialog.setCancelable(false)
        passDialog.setCanceledOnTouchOutside(true)
        passDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        passDialog.show()
    }
}