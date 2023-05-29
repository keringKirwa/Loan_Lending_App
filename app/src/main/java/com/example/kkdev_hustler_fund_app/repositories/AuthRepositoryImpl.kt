package com.example.kkdev_hustler_fund_app.repositories

import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.Result
import com.example.kkdev_hustler_fund_app.repositories.api.AuthApiService
import com.example.kkdev_hustler_fund_app.repositories.interfaces.AuthRepository
import com.example.kkdev_hustler_fund_app.models.Result.Error
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AuthRepositoryImpl(private val apiService: AuthApiService) : AuthRepository {

    override suspend fun loginUser(loginData: LoginDetails): Result {

        val retrofit = Retrofit.Builder()
            .baseUrl("/home/login")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(AuthApiService::class.java)

        return try {
            val response = apiService.login(loginData)

            if (response.isSuccessful) {
                val user =response.body()
                if (user != null) {
                    Result.Success(user)
                } else {
                     Error(response.message())
                }
            } else {
                Error(response.message())
            }
        } catch (e: Exception) {
            Result.ExceptionResult(e)
        }
    }
}
