package com.example.splashscreen.repository

import com.example.splashscreen.api.RetrofitInstance

import com.example.splashscreen.model.LoginRequest
import com.example.splashscreen.model.LoginResponse
import com.example.splashscreen.model.UsersListResponse
import retrofit2.Response

class UserList {
     suspend fun getUsersList(): Response<UsersListResponse> {

         return RetrofitInstance.api.geUsersList(2)
    }
}