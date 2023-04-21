package com.example.splashscreen


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.splashscreen.databinding.LoginActivityBinding
import com.example.splashscreen.fragments.LoginFragment


class LoginActivity : AppCompatActivity() {
    private lateinit var loginActivity: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.login_activity)
        loginActivity = LoginActivityBinding.inflate(layoutInflater)
        setContentView(loginActivity.root)
        loginActivity.toolbarTop.title = ""
//        val toolBarTop: Toolbar = findViewById(R.id.toolbar_top)
//        toolBarTop.title = ""
        setSupportActionBar(loginActivity.toolbarTop)
        addFragments()
    }



    private  fun addFragments(){
        // Begin the transaction
        // Begin the transaction
        val ft = supportFragmentManager.beginTransaction()
    // Replace the contents of the container with the new fragment
    // Replace the contents of the container with the new fragment
        ft.replace(R.id.placeholder, LoginFragment())
        // or ft.add(R.id.placeholder, LoginFragment())
    // Complete the changes added above
    // or  ft.add(R.id.placeholder, LoginFragment())
    // Complete the changes added above
        ft.commit()
    }


}