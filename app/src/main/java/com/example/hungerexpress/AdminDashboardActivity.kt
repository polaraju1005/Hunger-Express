package com.example.hungerexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import java.util.Timer

class AdminDashboardActivity : AppCompatActivity() {

    private lateinit var buttonMenu:ImageView

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
        setContentView(R.layout.activity_admin_dashboard)

        buttonMenu = findViewById(R.id.imgMenu)

        postersDataList = ArrayList<PostersData>()
        swipeTimer = Timer()

        firebaseStorage = Firebase.storage
        storageRef = firebaseStorage.reference

        dotsIndicator = findViewById<WormDotsIndicator>(R.id.dots_indicator)
        carousel = findViewById(R.id.carousel)
        carousel.registerLifecycle(lifecycle)

        buttonMenu.setOnClickListener {
            val intent = Intent(this@AdminDashboardActivity,AdminNavigationActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
        }

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