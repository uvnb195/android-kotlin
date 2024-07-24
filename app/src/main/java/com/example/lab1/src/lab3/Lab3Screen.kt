package com.example.lab1.src.lab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab1.ShowName
import com.example.lab1.src.components.Lab3Button

@Composable
fun Lab3Screen(navController: NavController) {
    val text = remember {
        mutableStateOf("Dao Huu Quan - PD09237")
    }
    val timer = remember {
        mutableIntStateOf(1)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 50.dp)
    ) {
        ShowName(name = text.value)
        Spacer(modifier = Modifier.height(20.dp))
        Lab3Button(title = "QUan",
            onClick = {
                if (timer.intValue == 1) {
                    text.value = "Hi !!!"
                } else {
                    text.value = "You have clicked the button ${timer.intValue} times."
                }
                timer.intValue++
            })
        Button(onClick = { navController.navigate("lab4-login")}) {
            Text(text = "Go to Lab4")
        }
    }
}