package com.example.lab1.src.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab1.R

@Composable
fun Lab5LightControl(navController: NavController) {
    var lightStatus by remember {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(if (lightStatus) Color.DarkGray else Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        if (lightStatus){
            Image(painter = painterResource(id = R.drawable.light_on), contentDescription = null)
        }else {
            Image(painter = painterResource(id = R.drawable.light_off), contentDescription = null)
        }
        Switch(checked = lightStatus, onCheckedChange ={lightStatus = !lightStatus} ,
            modifier = Modifier.padding(top = 20.dp))
        Button(onClick = { navController.navigate("lab5-chips")}) {
            Text(text = "Go to Lab5 Chips")
        }
    }
}