package com.example.splashscreen.repository

import com.example.splashscreen.api.RetrofitInstance
import com.example.splashscreen.model.LoginRequest
import com.example.splashscreen.model.LoginResponse
import retrofit2.Response

class LoginRepository:Authentication {



    override suspend fun sigIn(email: String, password: String): Response<LoginResponse> {
        val loginRequest = LoginRequest(email, password)
        return RetrofitInstance.api.login(loginRequest)
    }

}