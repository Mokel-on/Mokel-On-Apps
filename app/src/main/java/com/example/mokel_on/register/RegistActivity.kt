package com.example.mokel_on.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
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

        binding.btnRegist.setOnClickListener {
            val nama = binding.nameRegist.text.toString()
            val username = binding.unRegist.text.toString()
            val email = binding.emailReg.text.toString()
            val password = binding.passReg.text.toString()
            val confirmPw = binding.cmpassReg.text.toString()


        if (email.isEmpty()) {
            binding.emailReg.error = "Wajib Diisi!"
            binding.emailReg.requestFocus()
            return@setOnClickListener
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailReg.error = "Email Tidak Valid!"
            binding.emailReg.requestFocus()
            return@setOnClickListener
        }

        if (nama.isEmpty()) {
            binding.nameRegist.error = "Wajib Diisi!"
            binding.nameRegist.requestFocus()
            return@setOnClickListener
        }
        if (username.isEmpty()) {
            binding.unRegist.error = "Wajib Diisi!"
            binding.unRegist.requestFocus()
            return@setOnClickListener
        }

        if (password.isEmpty()) {
            binding.passReg.error = "Wajib Diisi!"
            binding.passReg.requestFocus()
            return@setOnClickListener
        }
        if (confirmPw.isEmpty()) {
            binding.cmpassReg.error = "Wajib Diisi!"
            binding.cmpassReg.requestFocus()
            return@setOnClickListener
        }

        if (password.length < 8) {
            binding.passReg.error = "Minimal 8 Karakter!"
            binding.passReg.requestFocus()
            return@setOnClickListener
        }

        if (!password.equals(confirmPw)) {
            binding.passReg.error = "Password Tidak Sesuai!"
            binding.cmpassReg.error = "Password Tidak Sesuai!"
            binding.cmpassReg.requestFocus()
            return@setOnClickListener
        }

        RegisterFirebase(email, password)


    }

}

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Succesfull", Toast.LENGTH_SHORT).show()
                    intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
