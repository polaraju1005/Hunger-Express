package com.example.hungerexpress

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible

class AdminNavigationActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView

    private lateinit var restaurants: RelativeLayout
    private lateinit var addRestaurant: RelativeLayout
    private lateinit var modifyRestaurant: RelativeLayout
    private lateinit var deleteRestaurant: RelativeLayout

    private lateinit var changePass: RelativeLayout
    private lateinit var allOrders: RelativeLayout

    private lateinit var deliveryDriver: RelativeLayout
    private lateinit var addDriver: RelativeLayout
    private lateinit var editDriver: RelativeLayout

    private lateinit var profile: RelativeLayout
    private lateinit var settings: RelativeLayout
    private lateinit var update: RelativeLayout
    private lateinit var manageAdd: RelativeLayout

    private lateinit var buttonLogout: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_navigation)

        backButton = findViewById(R.id.backButtonIcon)

        restaurants = findViewById(R.id.relativeRestraunts)
        addRestaurant = findViewById(R.id.relativeAddRestaurant)
        modifyRestaurant = findViewById(R.id.relativeModifyRes)
        deleteRestaurant = findViewById(R.id.relativeDeleteRes)

        changePass = findViewById(R.id.relativeChangePass)
        allOrders = findViewById(R.id.relativeAllOrders)

        deliveryDriver = findViewById(R.id.relativeDrivers)
        addDriver = findViewById(R.id.relativeAddDriver)
        editDriver = findViewById(R.id.relativeEditDriver)

        profile = findViewById(R.id.relativeProfile)
        settings = findViewById(R.id.relativeSettings)
        update = findViewById(R.id.relativeUpate)
        manageAdd = findViewById(R.id.relativeManageAdd)

        buttonLogout = findViewById(R.id.btnLogoutAdm)


        backButton.setOnClickListener {
            val intent = Intent(this, AdminDashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
        }

        restaurants.setOnClickListener {
            addRestaurant.isVisible = true
            modifyRestaurant.isVisible = true
            deleteRestaurant.isVisible = true
        }

        addRestaurant.setOnClickListener {
            showAddRestaurantDialog()
        }

        modifyRestaurant.setOnClickListener {
            showModifyRestaurantDialog()
        }

        deleteRestaurant.setOnClickListener {
            showDeleteRestaurantDialog()
        }

        deliveryDriver.setOnClickListener {
            addDriver.isVisible = true
            editDriver.isVisible = true
        }

        profile.setOnClickListener {
            settings.isVisible = true
            update.isVisible = true
            manageAdd.isVisible = true
        }

        buttonLogout.setOnClickListener {
            startActivity(Intent(this@AdminNavigationActivity, LoginActivity::class.java))
            finishAffinity()
        }

    }

    private fun showDeleteRestaurantDialog() {
        val deleteResDialog = Dialog(this)
        deleteResDialog.setContentView(R.layout.delete_res_dialog)
        deleteResDialog.setCancelable(false)
        deleteResDialog.setCanceledOnTouchOutside(true)
        deleteResDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        deleteResDialog.findViewById<TextView>(R.id.txtCancelBtn).setOnClickListener {
            deleteResDialog.dismiss()
        }

        deleteResDialog.findViewById<TextView>(R.id.txtDeleteBtn).setOnClickListener {
            Toast.makeText(this@AdminNavigationActivity, "Restaurant Deleted", Toast.LENGTH_SHORT)
                .show()
            deleteResDialog.dismiss()
        }

        deleteResDialog.show()
    }

    private fun showModifyRestaurantDialog() {
        val modifyResDialog = Dialog(this)
        modifyResDialog.setContentView(R.layout.modify_res_dailog)
        modifyResDialog.setCancelable(false)
        modifyResDialog.setCanceledOnTouchOutside(true)
        modifyResDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        modifyResDialog.findViewById<TextView>(R.id.txtCancelBtn).setOnClickListener {
            modifyResDialog.dismiss()
        }

        modifyResDialog.findViewById<TextView>(R.id.txtModifyBtn).setOnClickListener {
            Toast.makeText(this@AdminNavigationActivity, "Restaurant Modified", Toast.LENGTH_SHORT)
                .show()
            modifyResDialog.dismiss()
        }

        modifyResDialog.show()
    }

    private fun showAddRestaurantDialog() {
        val addResDialog = Dialog(this)
        addResDialog.setContentView(R.layout.addres_dialog)
        addResDialog.setCancelable(false)
        addResDialog.setCanceledOnTouchOutside(true)
        addResDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        addResDialog.findViewById<TextView>(R.id.txtCancelBtn).setOnClickListener {
            addResDialog.dismiss()
        }

        addResDialog.findViewById<TextView>(R.id.txtAddBtn).setOnClickListener {
            Toast.makeText(this@AdminNavigationActivity, "Restaurant Added", Toast.LENGTH_SHORT)
                .show()
            addResDialog.dismiss()
        }

        addResDialog.show()
    }
}