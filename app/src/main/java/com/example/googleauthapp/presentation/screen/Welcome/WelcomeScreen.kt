package com.example.googleauthapp.presentation.screen.Welcome

import TopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.googleauthapp.navigation.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavHostController) {
    val contextForToast = LocalContext.current.applicationContext
    Scaffold(topBar = {
        TopBar(
            onclickPesquisar = {
                navController.navigate(Screen.Home.route)
            },
            onClickAdd = {
                navController.navigate(Screen.AddMercado.route)
            },
            onClickHome = {
                navController.navigate(Screen.Welcome.route)
            }
        ) }){
        Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .size(250.dp),
                    painter = painterResource(id = com.example.googleauthapp.R.drawable.app_mercado_logo),
                    contentDescription = "Google Logo"
                )
                Text(
                    text = stringResource(id = com.example.googleauthapp.R.string.welcome_title),
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .padding(bottom = 40.dp, top = 4.dp),
                    text = stringResource(id = com.example.googleauthapp.R.string.welcome_subtitle),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    textAlign = TextAlign.Center
                )

        }





    }
}