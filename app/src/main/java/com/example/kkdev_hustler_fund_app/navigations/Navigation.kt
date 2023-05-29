package com.example.kkdev_hustler_fund_app.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kkdev_hustler_fund_app.screens.HomeScreen
import com.example.kkdev_hustler_fund_app.screens.LoginScreenTest

object Navigation {

    @Composable
    fun SetupNavigation() {
        val navController = rememberNavController()
        remember { navController }

        NavHost(navController = navController, startDestination = Route.LoginScreenRoute.routeName) {


            composable(Route.LoginScreenRoute.routeName) {
                LoginScreenTest()

            }
            composable(Route.HomeScreenRoute.routeName) {
                HomeScreen()

            }

        }
    }

    fun onNavigate(route: Route, navController: NavController){
        navController.navigate(route.routeName)

    }




}