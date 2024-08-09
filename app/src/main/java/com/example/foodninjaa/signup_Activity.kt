package com.example.foodninjaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup_Activity : AppCompatActivity() {
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val txt=findViewById<TextView>(R.id.textView11)
        txt.setOnClickListener{
            //open a new activity
            intent= Intent(applicationContext,login_Activity::class.java)
            startActivity(intent)
        }


        val btn=findViewById<Button>(R.id.button3)
        val etName=findViewById<EditText>(R.id.editTextText)
        val etMail=findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val etPassword=findViewById<EditText>(R.id.editTextTextPassword2)

        btn.setOnClickListener {

            val name=etName.text.toString()
            val mail=etMail.text.toString()
            val password=etPassword.text.toString()

            val user=User(name,mail,password)

         // node tak jane ka code
            database = FirebaseDatabase.getInstance().getReference("Users")

            database.child(name).setValue(user).addOnSuccessListener {

                etName.text?.clear()
                Toast.makeText(this,"User registered",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Registration failed",Toast.LENGTH_SHORT).show()
            }

            intent= Intent(applicationContext,signup_process_Activity::class.java)
            startActivity(intent)

        }

    }
}