package com.example.rickandmortycharacters.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortycharacters.R
import com.example.rickandmortycharacters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}