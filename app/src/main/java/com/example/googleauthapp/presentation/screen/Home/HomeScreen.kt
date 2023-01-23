package com.example.googleauthapp.presentation.screen.Home

import TopBar
import android.annotation.SuppressLint

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.googleauthapp.R
import com.example.googleauthapp.component.ExposedDropMenuStateHolder
import com.example.googleauthapp.component.rememberExposedMenuStateHolder
import com.example.googleauthapp.domain.model.Mercado
import com.example.googleauthapp.navigation.Screen
import com.example.googleauthapp.presentation.screen.AdicionarMercado.ExposedDropDownMenu


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HommeViewModel = hiltViewModel()
) {

    val listaMercado by homeViewModel.lista1

    var dia by remember { mutableStateOf("") }
    var promo by remember { mutableStateOf("") }
    var pesquisar by remember { mutableStateOf(false) }

    Scaffold(topBar = { TopBar(
        onclickPesquisar = {
            navController.navigate(Screen.Home.route)
        },
        onClickAdd = {
            navController.navigate(Screen.AddMercado.route)
        },
        onClickHome = {
            navController.navigate(Screen.Welcome.route)
        }
    ) }) {
        Column(modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            if (pesquisar){
                MostrarListaFiltrada(listaMercado, dia, promo)
            }else{
                Text(
                    text = "Procurar:",
                    style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                )
                val stateHolderPromo = rememberExposedMenuStateHolder()
                val stateHolderDias = rememberExposedMenuStateHolder()
                ExposedDropDownMenu(stateHolder = stateHolderPromo, text = "Tipo promo:")
                ExposedDropDownMenuDias(stateHolder = stateHolderDias, text = "Dia:")
                promo = stateHolderPromo.valueItem
                dia = stateHolderDias.valueDia

//                IconButton(onClick = {pesquisar=true},
//                    modifier = Modifier.background(color = Color.DarkGray)
//                ) {
//                    Row() {
//                        Text(text = "Pesquisar")
//                        Spacer(modifier = Modifier.size(5.dp))
//                        Icon(Icons.Rounded.Search, contentDescription = "Pesquisar")
//                    }
//
//                }
                Spacer(modifier = Modifier.size(15.dp))
                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {pesquisar=true
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ) {
                        Row() {
                            Text(text = "Pesquisar")
                            Spacer(modifier = Modifier.size(5.dp))
                            Icon(Icons.Rounded.Search, contentDescription = "Pesquisar")
                        }
                    }
                }
            }

        }
    }



}

@Composable
fun MostrarListaFiltrada(listaMercado: List<Mercado>, dia: String, promo: String) {

    Text(
        text = "MERCADOS:",
        fontWeight = FontWeight.Bold,
        fontSize = MaterialTheme.typography.h4.fontSize
    )
    Spacer(modifier = Modifier.size(8.dp))
    LazyColumn(){
        items(items = listaMercado, itemContent = {mercado ->
            if(mercado.dia[dia] == promo){
                Text(text = "${mercado.name}",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize)
            }




        })
    }
}

@Composable
fun ExposedDropDownMenuDias(stateHolder: ExposedDropMenuStateHolder, text: String){
    Column {
        Box {
            OutlinedTextField(
                value = stateHolder.valueDia,
                onValueChange = {},
                label = { Text(text = text) },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vertical_menu),
                        contentDescription = null,
                        Modifier.clickable {
                            stateHolder.onEnabled(!(stateHolder.enabled))
                        }
                    )
                },
                modifier = Modifier.onGloballyPositioned {
                    stateHolder.onSize(it.size.toSize())
                }
            )
            DropdownMenu(
                expanded = stateHolder.enabled,
                onDismissRequest = {
                    stateHolder.onEnabled(false)
                },
                modifier = Modifier.width(with(LocalDensity.current){
                    stateHolder.size.width.toDp()
                })
            ) {
                stateHolder.dias.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        onClick = {
                            stateHolder.onSelectedIndexDias(index)
                            stateHolder.enabled = false
                        }
                    ) {
                        Text(text = s)
                    }

                }
            }
        }
    }
}


