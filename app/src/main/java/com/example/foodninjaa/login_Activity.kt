package com.example.foodninjaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class login_Activity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginInButton = findViewById<Button>(R.id.btnlogin)
        val emailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)


        loginInButton.setOnClickListener {

            val eMailID = emailAddress.text.toString()
            if(eMailID.isNotEmpty()){
                readData(eMailID)
            } else{
                Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show()
            }
        }
    }  // onCreate Method over

    private fun readData(mail : String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(mail).get().addOnSuccessListener {
            // if user exist or not
            if(it.exists()){
                // welcome user in your app, with intent and also pass
                val intentHome = Intent(this, Home_Activity::class.java)
                startActivity(intentHome)
            }else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "User doesn,t exist, please first signup", Toast.LENGTH_SHORT).show()
        }
    }
}