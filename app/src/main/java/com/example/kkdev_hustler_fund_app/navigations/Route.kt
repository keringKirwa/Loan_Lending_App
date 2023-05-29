package com.example.kkdev_hustler_fund_app.navigations


sealed class Route(val routeName: String) {

    object HomeScreenRoute:Route("HomeScreen")
    object LoginScreenRoute:Route("LoginScreen")


}