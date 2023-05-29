package com.example.kkdev_hustler_fund_app.models

import java.lang.Exception

sealed class Result() {
    data class Success(val user: User) : Result()
    data class Error(val exceptionMessage: String) : Result()
    data class ExceptionResult(val exception: Exception) : Result()
    object  Loading : Result()
}