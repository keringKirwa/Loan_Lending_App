package com.example.kkdev_hustler_fund_app.navigations

sealed class Routes(val routeName: String) {

    object HomeScreenRoute:Routes("LandingScreen")
    object LoginScreenRoute:Routes("Login")
}