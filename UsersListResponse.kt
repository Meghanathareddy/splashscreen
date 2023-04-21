package com.example.splashscreen.model

import com.google.gson.annotations.SerializedName

data class UsersListResponse (
    @SerializedName("data") val data : List<Data>
)