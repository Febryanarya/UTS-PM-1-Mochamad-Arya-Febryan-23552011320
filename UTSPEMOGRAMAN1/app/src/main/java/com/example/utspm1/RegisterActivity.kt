package com.example.utspm1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNama = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Ganti nama SharedPreferences ke tema outdoor
        sharedPref = getSharedPreferences("OutdoorRentalPref", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data untuk mendaftar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan data user ke SharedPreferences
            sharedPref.edit()
                .putString("USERNAME", nama)
                .putString("EMAIL", email)
                .putString("PASSWORD", password)
                .apply()

            Log.d("REGISTER", "Nama: $nama, Email: $email")
            Toast.makeText(this, "Pendaftaran berhasil! Siap menyewa alat outdoor, $nama! 🏕️", Toast.LENGTH_LONG).show()

            // Arahkan ke halaman login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
