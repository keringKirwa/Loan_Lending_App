package com.example.kkdev_hustler_fund_app.repositories.api

import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface AuthApiService {
    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): Response<User>

    @POST("login")
    suspend fun login(@Body loginRequest: LoginDetails): Response<User>
}
