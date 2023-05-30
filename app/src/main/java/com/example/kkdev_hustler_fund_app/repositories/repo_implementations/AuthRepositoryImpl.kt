package com.example.kkdev_hustler_fund_app.repositories.repo_implementations

import android.util.Log
import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.RequestResult
import com.example.kkdev_hustler_fund_app.models.User
import com.example.kkdev_hustler_fund_app.repositories.api.AuthApiService
import com.example.kkdev_hustler_fund_app.repositories.interfaces.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AuthRepositoryImpl() : AuthRepository {


    override fun loginUser(loginDetails: LoginDetails): Flow<RequestResult<out Any, String>> {
        return flow{

            val retrofit = Retrofit.Builder()
                .baseUrl("/home/login")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(AuthApiService::class.java)
            emit(RequestResult.Loading<Boolean,String>(true, "Loading"));


            val res = apiService.login(loginDetails)

            if(res.body() != null){

                val user = res.body()
                emit(RequestResult.Success<User, String>(user, "Successfully Logged In"))

            }

        }.catch {
            emit(RequestResult.Success<User, String>(User("kelvin", "kering@gmail.com"), "Successfully Logged In"))
            Log.d("Auth Repo Layer:: ", "No endpoint available: emitting Success Instead.")
//            emit(RequestResult.Failure<Any, String>(null, message = it.message.toString()))

        }

    }
}
