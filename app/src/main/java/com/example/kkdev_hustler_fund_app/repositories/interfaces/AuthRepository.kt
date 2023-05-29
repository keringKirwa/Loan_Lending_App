package com.example.kkdev_hustler_fund_app.repositories.interfaces

import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.Result
import com.example.kkdev_hustler_fund_app.models.User

interface AuthRepository {
    suspend fun loginUser(loginData: LoginDetails): Result
}