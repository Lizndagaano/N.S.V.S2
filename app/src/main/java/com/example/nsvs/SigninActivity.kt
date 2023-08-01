package com.example.nsvs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        auth = FirebaseAuth.getInstance()

        val signinText = findViewById<TextView>(R.id.sig_in_text)
        val signinBtn = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.signin_btn)
        val email = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.email)
        val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.password)


        signinText.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
       signinBtn.setOnClickListener {
           val emailString = email.text.toString()
           val passwordstring = password.text.toString()
           if (emailString.isEmpty() || passwordstring.isEmpty()) {
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_LONG).show()
            } else {
                auth.signInWithEmailAndPassword(emailString, passwordstring).addOnCompleteListener {
                    task->
                    if (task.isSuccessful){
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, task.exception?.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }

        }


    }



}