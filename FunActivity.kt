package com.example.funlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.funlibrary.databinding.ActivityFunBinding

class FunActivity : AppCompatActivity() {
    private lateinit var funBinding: ActivityFunBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun)
        funBinding = ActivityFunBinding.inflate(layoutInflater)
        setContentView(funBinding.root)
        Log.d("funBinding","${funBinding.`fun`.text}")

    }
}