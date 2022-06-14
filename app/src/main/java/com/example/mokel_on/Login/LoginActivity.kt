package com.example.mokel_on.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.mokel_on.databinding.ActivityLoginBinding
import com.example.mokel_on.home.HomeActivity
import com.example.mokel_on.register.RegistActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        auth = FirebaseAuth.getInstance()

        binding.txtButton2.setOnClickListener{
            val intent = Intent(this@LoginActivity,RegistActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.logEmail.text.toString()
            val password = binding.loginPw.text.toString()

            if (email.isEmpty()) {
                binding.logEmail.error = "Required!"
                binding.logEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.logEmail.error = "Email doesn't match"
                binding.logEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.loginPw.error = "Required!"
                binding.loginPw.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email, password)
        }

    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Completed", Toast.LENGTH_SHORT).show()
                    intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }


    }
}