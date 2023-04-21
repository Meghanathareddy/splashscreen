package com.example.splashscreen.repository

import com.example.splashscreen.model.LoginResponse
import retrofit2.Response

interface Authentication {
    suspend fun sigIn(email:String, password:String): Response<LoginResponse>
}