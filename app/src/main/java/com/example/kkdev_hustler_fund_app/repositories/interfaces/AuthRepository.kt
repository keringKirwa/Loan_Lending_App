package com.example.kkdev_hustler_fund_app.repositories.interfaces

import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.RequestResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
     fun loginUser(loginDetails: LoginDetails): Flow<RequestResult<out Any, String>>
}