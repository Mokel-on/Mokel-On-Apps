package com.example.mokel_on.home

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.UrlQuerySanitizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mokel_on.Adapters.Adapters
import com.example.mokel_on.Data.Data
import com.example.mokel_on.R
import com.example.mokel_on.bengkel.DetailBengkelActivity
import com.example.mokel_on.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var myAdapter:Adapters
    private lateinit var db: FirebaseFirestore
    private lateinit var DataArrayList: ArrayList<Data>
    private lateinit var Recycle: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //supportActionBar!!.hide()

        Recycle = findViewById(R.id.bengkel_list)
        Recycle.layoutManager = LinearLayoutManager(this)
        Recycle.setHasFixedSize(true)

        DataArrayList = arrayListOf()

        myAdapter = Adapters(DataArrayList)

        Recycle.adapter = myAdapter

        EventChangeListener()

        val navView : BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_nav)
        val appBarConfiguration = AppBarConfiguration.Builder(
         R.id.navigation_home, R.id.navigation_maps, R.id.navigation_profile
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val imgswitcher = findViewById<ImageSwitcher>(R.id.switcher_1)
        imgswitcher?.setFactory {
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        }

        myAdapter.notifyDataSetChanged()
        myAdapter.setOnItemClickCallback(object : Adapters.OnItemClickCallback {
            override fun OnItemClicked(data: Data) {
                Intent(this@HomeActivity, DetailBengkelActivity::class.java).also {
                    startActivity(it)
                }
            }
        })

    }

    private fun EventChangeListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("Data")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

                /*'addSnapshotListener(object : EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error != null){

                            Log.e("Firestore Error",error.message.toString())
                            return
                        }
                        for (dc :DocumentChange in value?.documentChanges!!){

                            if (dc.type == DocumentChange.Type.ADDED){
                                DataArrayList.add(dc.document.toObject(Data::class.java))
                            }
                        }

                        myAdapter.notifyDataSetChanged()

                    }

                })
    */

    }
}