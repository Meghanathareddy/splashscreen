package com.example.splashscreen

import com.example.splashscreen.model.Data
import com.example.splashscreen.model.Support
import com.google.gson.annotations.SerializedName

data class UserListItems(
                         @SerializedName("data") val data: List<Data>
)
