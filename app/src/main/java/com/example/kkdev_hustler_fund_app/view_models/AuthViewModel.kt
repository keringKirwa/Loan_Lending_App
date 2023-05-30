package com.example.kkdev_hustler_fund_app.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.RequestResult
import com.example.kkdev_hustler_fund_app.models.User
import com.example.kkdev_hustler_fund_app.navigations.Destinations
import com.example.kkdev_hustler_fund_app.repositories.repo_implementations.AuthRepositoryImpl
import com.example.kkdev_hustler_fund_app.repositories.interfaces.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel() : ViewModel() {

    val loggedInUser :User ? =null

    private val _loginState = MutableStateFlow<User?>(null)
    val loginState: StateFlow<User?> = _loginState

    fun loginUser(email: String, password: String, navController: NavController){

        val loginDetails  = LoginDetails(email, password)

        viewModelScope.launch {
            val authRepository : AuthRepository = AuthRepositoryImpl()

            authRepository.loginUser(loginDetails).collect{
                when(it){
                    is RequestResult.Success -> {
                        Log.d("VIEW_MODEL_SUCCESS::", it.data.toString())

                        navController.navigate(Destinations.HomeScreenRoute.routeName)
                        _loginState.value= it.data as User?
                        Log.d("VIEW_MODEL_STATE::",_loginState.value.toString())

                    }
                    is RequestResult.Failure -> {
                        Log.d("VIEW-MODEL MESSAGE ", "Request Failure ! ")
                    }

                    is RequestResult.Loading -> {}

                }

            }

        }
    }
}

