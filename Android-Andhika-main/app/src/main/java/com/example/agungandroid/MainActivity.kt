package com.example.agungandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.content.Intent
import android.view.View
import android.net.Uri

class MainActivity : AppCompatActivity() {
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ambil view dari layout
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        val buttonMaps = findViewById<Button>(R.id.button_maps)       // Tombol Maps
        val buttonContacts = findViewById<Button>(R.id.button_contacts) // Tombol Kontak

        // Tombol Count Up
        buttonCountUp.setOnClickListener {
            mCount++
            Log.d("mCount", mCount.toString())
            mShowCount.text = mCount.toString()
        }

        // Tombol Toast
        buttonToast.setOnClickListener {
            val tulisan: String = mShowCount.text.toString()
            Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG).show()
        }

        // Tombol Pindah Halaman
        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // Tombol Buka Browser
        buttonBrowser.setOnClickListener {
            val intentbrowse = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(intentbrowse)
        }

        // Tombol Buka Maps
        buttonMaps.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:-6.917464,107.619123?q=Bandung") // contoh ke Bandung
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps") // pastikan buka di Google Maps
            startActivity(mapIntent)
        }

        // Tombol Buka Kontak
        buttonContacts.setOnClickListener {
            val contactIntent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
            startActivity(contactIntent)
        }

        // Supaya layout tidak ketimpa status bar/navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}