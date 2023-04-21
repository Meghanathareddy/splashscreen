package com.example.splashscreen

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.splashscreen.fragments.LoginFragment

class LoadingDialog(myActivity: Context) {

    private var activity: Context = myActivity
    private lateinit var dialog: AlertDialog

    fun startLoadingDialog(){
        //adding ALERT builder OBJECT and passing activity as parameter
        val builder = AlertDialog.Builder(activity)
        // layout Inflater object and use activity to get layout inflater
        val inflater:LayoutInflater = LayoutInflater.from(activity)
        builder.setView(inflater.inflate(R.layout.loading,null))
        builder.setCancelable(true)
        dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    //dismiss method
    fun dismissDialog(){
        dialog.dismiss()
    }



}




