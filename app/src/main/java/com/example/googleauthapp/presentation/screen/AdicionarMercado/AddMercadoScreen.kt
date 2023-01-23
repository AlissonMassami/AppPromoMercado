package com.example.googleauthapp.presentation.screen.AdicionarMercado

import TopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.googleauthapp.R
import com.example.googleauthapp.component.ExposedDropMenuStateHolder
import com.example.googleauthapp.component.rememberExposedMenuStateHolder
import com.example.googleauthapp.domain.model.Dia
import com.example.googleauthapp.domain.model.MercadoApi
import com.example.googleauthapp.navigation.Screen
import com.example.googleauthapp.util.Constants.SPACER

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddMercadoScreen(
    navController: NavHostController,
    addMercadoViewModel: AddMercadoViewModel = hiltViewModel()
) {
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
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val nome = remember {
                mutableStateOf(TextFieldValue())
            }

            val stateHolderDom = rememberExposedMenuStateHolder()
            val stateHolderSeg = rememberExposedMenuStateHolder()
            val stateHolderTer = rememberExposedMenuStateHolder()
            val stateHolderQua = rememberExposedMenuStateHolder()
            val stateHolderQui = rememberExposedMenuStateHolder()
            val stateHolderSex = rememberExposedMenuStateHolder()
            val stateHolderSab = rememberExposedMenuStateHolder()

            Text(
                text = "Novo Mercado",
                style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                label = { Text(text = "Nome Mercado") },
                value = nome.value,
                onValueChange = { nome.value = it }
            )
            ExposedDropDownMenu(stateHolder = stateHolderDom, text = "Domingo")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderSeg, text = "Segunda")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderTer, text = "Terça")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderQua, text = "Quarta")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderQui, text = "Quinta")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderSex, text = "Sexta")
            Spacer(modifier = Modifier.height(SPACER.dp))
            ExposedDropDownMenu(stateHolder = stateHolderSab, text = "Sábado")
            Spacer(modifier = Modifier.height(SPACER.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {
                              val dias = Dia(
                                  domingo = stateHolderDom.valueItem,
                                  segunda = stateHolderSeg.valueItem,
                                  terca = stateHolderTer.valueItem,
                                  quarta = stateHolderQua.valueItem,
                                  quinta = stateHolderQui.valueItem,
                                  sexta = stateHolderSex.valueItem,
                                  sabado = stateHolderSab.valueItem
                              )
                            val novoMercado = MercadoApi(
                                name = nome.value.text,
                                dia = dias
                            )
                            addMercadoViewModel.inserirNovoMercadoDB(novoMercado)



                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Adicionar")
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

        }
    }

    
}



@Composable
fun ExposedDropDownMenu(stateHolder: ExposedDropMenuStateHolder, text: String){
    Column {
        Box {
            OutlinedTextField(
                value = stateHolder.valueItem,
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
                    stateHolder.items.forEachIndexed { index, s ->
                        DropdownMenuItem(
                            onClick = {
                                stateHolder.onSelectedIndex(index)
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