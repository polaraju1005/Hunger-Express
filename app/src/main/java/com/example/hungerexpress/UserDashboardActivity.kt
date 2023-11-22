package com.example.hungerexpress

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import java.util.Timer

class UserDashboardActivity : AppCompatActivity() {
    private lateinit var menu: ImageView
    private lateinit var cart: ImageView
    private lateinit var relativeRes1: RelativeLayout
    private lateinit var relativeRes2: RelativeLayout
    private lateinit var relativeRes3: RelativeLayout
    private lateinit var relativeRes4: RelativeLayout
    private lateinit var relativeRes5: RelativeLayout

    lateinit var swipeTimer: Timer
    lateinit var postersViewPager2: ViewPager2
    lateinit var postersAdapter: PostersAdapter
    lateinit var postersDataList: ArrayList<PostersData>
    lateinit var dotsIndicator: WormDotsIndicator

    lateinit var carousel: ImageCarousel

    lateinit var firebaseStorage: FirebaseStorage
    lateinit var storageRef: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)

        supportActionBar?.hide()

        menu = findViewById(R.id.imgMenu)
        cart = findViewById(R.id.imgCart)
        relativeRes1 = findViewById(R.id.relativeRes1)
        relativeRes2 = findViewById(R.id.relativeRes2)
        relativeRes3 = findViewById(R.id.relativeRes3)
        relativeRes4 = findViewById(R.id.relativeRes4)
        relativeRes5 = findViewById(R.id.relativeRes5)

        postersDataList = ArrayList<PostersData>()
        swipeTimer = Timer()

        firebaseStorage = Firebase.storage
        storageRef = firebaseStorage.reference

        dotsIndicator = findViewById<WormDotsIndicator>(R.id.dots_indicator)
        carousel = findViewById(R.id.carousel)
        carousel.registerLifecycle(lifecycle)

        menu.setOnClickListener {
            val intent2 = Intent(this, UserNavigationActivity::class.java)
            startActivity(intent2)
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
        }

        cart.setOnClickListener {
            showCartDialog()
        }

        relativeRes1.setOnClickListener {
            showMenuDialog()
        }

        relativeRes2.setOnClickListener {
            showMenuDialog()
        }

        relativeRes3.setOnClickListener {
            showMenuDialog()
        }

        relativeRes4.setOnClickListener {
            showMenuDialog()
        }

        relativeRes5.setOnClickListener {
            showMenuDialog()
        }
    }

    private fun showCartDialog() {
        val cartDialog = Dialog(this)
        cartDialog.setContentView(R.layout.cart_dialog)
        cartDialog.setCancelable(false)
        cartDialog.setCanceledOnTouchOutside(true)
        cartDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        cartDialog.findViewById<TextView>(R.id.txtCancel).setOnClickListener {
            cartDialog.dismiss()
        }

        cartDialog.findViewById<TextView>(R.id.txtCheckOut).setOnClickListener {
            startActivity(Intent(this@UserDashboardActivity, CheckOutActivity::class.java))
        }

        cartDialog.show()
    }

    private fun showMenuDialog() {
        val menuDialog = Dialog(this)
        menuDialog.setContentView(R.layout.menu_moonlit_dialog)
        menuDialog.setCancelable(false)
        menuDialog.setCanceledOnTouchOutside(true)
        menuDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

//        val tv =
//            menuDialog.findViewById<TextView>(R.id.txtCount)
//
//        val curr:String = tv.text.toString()
//
//        var total:Int = curr.toInt()
//
//        menuDialog.findViewById<CardView>(R.id.btnMinus).setOnClickListener {
//            while (total > 0) {
//                total -= 1;
//            }
//
//        }
//
//        menuDialog.findViewById<CardView>(R.id.btnPlus).setOnClickListener {
//                total+=1;
//        }
//
//        tv.text = total.toString()

        menuDialog.show()
    }

    override fun onStart() {
        super.onStart()

        // Loading the Banners Data
        loadBannersData()
    }

    private fun loadBannersData() {
        val list = mutableListOf<CarouselItem>()

        val imagesRef: StorageReference = storageRef.child("posters")
        val imageRef: StorageReference = storageRef

        imagesRef.listAll().addOnSuccessListener {

            list.clear()
            for (item in it.items) {
                imageRef.child(item.path).downloadUrl.addOnSuccessListener { it ->
                    // For Banners ViewPager
                    Log.d("TAG", it.toString())
                    list.add(CarouselItem(it.toString()))

                    carousel.setData(list)
                }
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }
}