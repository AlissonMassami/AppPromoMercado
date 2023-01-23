package com.example.googleauthapp.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
    object AddMercado: Screen(route = "add_mercado")
    object Welcome: Screen(route = "welcome")
}
