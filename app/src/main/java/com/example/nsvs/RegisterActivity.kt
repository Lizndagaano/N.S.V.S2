package com.example.nsvs

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val signUpText = findViewById<TextView>(R.id.signUp_text)
        val CreateBtn = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.create_btn)
        val email = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.email)
        val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.password)



        signUpText.setOnClickListener{
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }

       CreateBtn.setOnClickListener {
           val emailString = email.text.toString()
           val passwordString = password.text.toString()
            if (emailString.isEmpty() || passwordString.isEmpty()) {
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(emailString, passwordString)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity2::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, task.exception?.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }

    }



}