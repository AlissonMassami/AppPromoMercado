package com.example.googleauthapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.googleauthapp.presentation.screen.AdicionarMercado.AddMercadoScreen
import com.example.googleauthapp.presentation.screen.Home.HomeScreen
import com.example.googleauthapp.presentation.screen.Welcome.WelcomeScreen
import com.example.googleauthapp.presentation.screen.login.LoginScreen


@ExperimentalCoilApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.AddMercado.route) {
            AddMercadoScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }


    }
}