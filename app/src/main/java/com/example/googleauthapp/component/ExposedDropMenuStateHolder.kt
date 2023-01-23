package com.example.googleauthapp.component

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size

class ExposedDropMenuStateHolder {

    var enabled by mutableStateOf(false)
    var valueItem by mutableStateOf("")
    var valueDia by mutableStateOf("")
    var selectedIndex by mutableStateOf(-1)
    var size by mutableStateOf(Size.Zero)
    val items = listOf("frutas", "carnes", "peixes", "limpeza")
    val dias = listOf("domingo", "segunda", "terça", "quarta","quinta","sexta","sabado",)

    fun onEnabled(newValue:Boolean){
        enabled = newValue
    }
    fun onSelectedIndex(newValue:Int){
        selectedIndex = newValue
        valueItem = items[selectedIndex]
    }
    fun onSelectedIndexDias(newValue:Int){
        selectedIndex = newValue
        valueDia = dias[selectedIndex]
    }
    fun onSize(newValue:Size){
        size = newValue
    }

}

@Composable
fun rememberExposedMenuStateHolder() = remember {
    ExposedDropMenuStateHolder()
}