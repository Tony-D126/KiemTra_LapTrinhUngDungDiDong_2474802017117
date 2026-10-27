package com.example.kiemtra_laptrinhungdungdidong_2474802017117

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvProfileTitle = findViewById<TextView>(R.id.tvProfileTitle)
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSkills = findViewById<ListView>(R.id.lvSkills)

        // Using tvProfileTitle to prevent unused variable warning
        tvProfileTitle.text = getString(R.string.profile_title)

        val email = intent.getStringExtra("USER_EMAIL")
        if (email != null) {
            tvUserEmail.text = email
        }

        btnLogout.setOnClickListener {
            finish()
        }

        val skills = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skills)
        lvSkills.adapter = adapter

        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val selectedSkill = skills[position]
            Toast.makeText(this, selectedSkill, Toast.LENGTH_SHORT).show()
        }
    }
}
