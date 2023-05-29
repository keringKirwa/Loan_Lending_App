package com.example.kkdev_hustler_fund_app.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkdev_hustler_fund_app.models.LoginDetails
import com.example.kkdev_hustler_fund_app.models.User
import com.example.kkdev_hustler_fund_app.repositories.interfaces.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AuthViewModel(private val userRepository: AuthRepository) : ViewModel() {
    private val _loginState = MutableStateFlow<Result<User>>(com.example.kkdev_hustler_fund_app.models.Result)
    val loginState: StateFlow<Result<User>> = _loginState

    fun loginUser(username: String, password: String) {
        val loginData = LoginDetails(username, password)
        viewModelScope.launch {
            _loginState.value = Result.Loading
            val result = userRepository.loginUser(loginData)
            _loginState.value = result
        }
    }
}
