package com.example.simpleform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Retrieve data from the Intent
        val firstName = intent.getStringExtra("FIRST_NAME")
        val middleName = intent.getStringExtra("MIDDLE_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val mobileNumber = intent.getStringExtra("MOBILE_NUMBER")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")
        val skills = intent.getStringExtra("SKILLS") // Retrieve skills

        // Find the TextView to display the data
        val textView = findViewById<TextView>(R.id.text_view_display)

        // Set the text to display the user's input
        textView.text = """
            Name: $firstName $middleName $lastName
            Mobile: $mobileNumber
            Email: $email
            Gender: $gender
            Skills: $skills
        """.trimIndent()
    }
}