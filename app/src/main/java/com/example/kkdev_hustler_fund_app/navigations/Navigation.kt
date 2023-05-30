package com.example.kkdev_hustler_fund_app.navigations

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkdev_hustler_fund_app.screens.HomeScreen
import com.example.kkdev_hustler_fund_app.screens.LoginScreenTest

object Navigation {
     @SuppressLint("CompositionLocalNaming")
     val navControllerLocal = staticCompositionLocalOf<NavController> {
        error("NavController not provided")
    }

    @Composable
    fun OnSetUpNavigationGraph() {
        val navController = rememberNavController()
        CompositionLocalProvider(navControllerLocal provides navController) {
            NavHost(navController = navController, startDestination = Destinations.LoginScreenRoute.routeName) {
                composable(Destinations.LoginScreenRoute.routeName) {
                    LoginScreenTest()
                }
                composable(Destinations.HomeScreenRoute.routeName) {
                    HomeScreen()
                }
            }
        }
    }

}


