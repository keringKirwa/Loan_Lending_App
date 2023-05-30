package com.example.kkdev_hustler_fund_app.navigations


sealed class Destinations(val routeName: String) {

    object HomeScreenRoute:Destinations("HomeScreen")
    object LoginScreenRoute:Destinations("LoginScreen")


}