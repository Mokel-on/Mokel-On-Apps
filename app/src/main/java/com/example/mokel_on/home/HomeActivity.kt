package com.example.mokel_on.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.ImageView
import com.example.mokel_on.Adapters.Adapters
import com.example.mokel_on.Data.Data
import com.example.mokel_on.R
import com.example.mokel_on.bengkel.DetailBengkelActivity
import com.example.mokel_on.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.list.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter:Adapters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val imgswitcher = findViewById<ImageSwitcher>(R.id.switcher_1)
        imgswitcher?.setFactory {
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        }
        adapter = Adapters()
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickCallback(object : Adapters.OnItemClickCallback {
            override fun OnItemClicked(data: Data) {
                Intent(this@HomeActivity, DetailBengkelActivity::class.java).also {

                    startActivity(it)
                }
            }
        })


    }
}