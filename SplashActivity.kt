package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import com.example.funlibrary.Customer

import com.example.splashscreen.databinding.ActivityMainBinding


@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        //create instance of the ActivityMainBinding,
        //as we have only one layout activity_main.xml
        binding= ActivityMainBinding.inflate(layoutInflater)
        //binding.root returns the root layout
        //which is activity_main.xml
        setContentView(binding.root)
        //This is used to hide the status bar and make
        //the splash screen as a full screen activity

        Log.d("Integration", "${BuildConfig.BASE_URL}")
//        Log.d("production", "${BuildConfig}")
        val customer = Customer("Meghanath")


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN ,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val sh: SharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        val token = sh.getString("token", "")
        //We used the postDelayed(Runnable, time) method
        //to send a message with a delayed time
        Handler().postDelayed({
           if (!token.isNullOrEmpty()){
               startActivity(Intent(this,DashBoardActivity::class.java))
           }else{
               startActivity(Intent(this,LoginActivity::class.java))
           }

            finish() },2000)



    }
}