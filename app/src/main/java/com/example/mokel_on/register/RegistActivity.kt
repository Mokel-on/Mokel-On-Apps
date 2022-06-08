package com.example.mokel_on.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mokel_on.Login.LoginActivity
import com.example.mokel_on.R
import com.example.mokel_on.databinding.ActivityRegistBinding
import com.google.firebase.auth.FirebaseAuth

class RegistActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        supportActionBar!!.hide()

        binding.txtButton2.setOnClickListener{
            val intent = Intent(this@RegistActivity,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}