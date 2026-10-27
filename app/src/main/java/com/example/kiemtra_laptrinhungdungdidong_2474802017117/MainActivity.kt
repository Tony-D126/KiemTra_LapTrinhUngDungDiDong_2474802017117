package com.example.kiemtra_laptrinhungdungdidong_2474802017117

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.setTextColor(Color.RED)
                tvStatus.text = "Vui lòng nhập đầy đủ Email và Mật khẩu!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setTextColor(Color.RED)
                tvStatus.text = "Email không đúng định dạng!"
            } else if (password.length < 6) {
                tvStatus.setTextColor(Color.RED)
                tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
            } else {
                tvStatus.setTextColor(Color.GREEN)
                tvStatus.text = "Xác thực thành công!"

                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("USER_EMAIL", email)
                }
                startActivity(intent)
            }
        }
    }
}
