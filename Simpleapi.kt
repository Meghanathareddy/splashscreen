package com.example.splashscreen.api

import com.example.splashscreen.model.LoginRequest
import com.example.splashscreen.model.LoginResponse
import com.example.splashscreen.model.UsersListResponse
import retrofit2.Response
import retrofit2.http.*


interface Simpleapi {
    @GET("posts")
    suspend fun getCustomPost(
        @Query("id") id:Int
    ):Response<UsersListResponse>

    @POST("/api/login")
    suspend fun login(
        @Body request: LoginRequest
    ):Response<LoginResponse>

    @GET("/api/users")
     suspend fun geUsersList(
        @Query("page") page:Int
    ):Response<UsersListResponse>
}