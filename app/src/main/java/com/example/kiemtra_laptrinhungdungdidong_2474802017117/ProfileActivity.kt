package com.example.kiemtra_laptrinhungdungdidong_2474802017117

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvProfileTitle = findViewById<TextView>(R.id.tvProfileTitle)
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Using tvProfileTitle to prevent unused variable warning
        tvProfileTitle.text = getString(R.string.profile_title)

        val email = intent.getStringExtra("USER_EMAIL")
        if (email != null) {
            tvUserEmail.text = email
        }

        btnLogout.setOnClickListener {
            finish()
        }
    }
}
