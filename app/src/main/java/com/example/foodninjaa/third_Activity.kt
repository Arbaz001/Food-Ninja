package com.example.foodninjaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class third_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val btn=findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            //open a new activity
            intent= Intent(applicationContext,login_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
}