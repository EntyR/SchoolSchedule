package com.example.schoolschedule

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val _menuInflater = menuInflater
        _menuInflater.inflate(R.menu.menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.changeUnitItem -> {
                val setting = getSharedPreferences("settings", Context.MODE_PRIVATE)
                setting.edit().putString("key", "ER").commit()
                findNavController(R.id.fragment).navigate(R.id.shooseClass)
                true
            }
            else -> false
        }


    }
}