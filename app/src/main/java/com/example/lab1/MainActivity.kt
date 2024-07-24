package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab1.src.lab3.Lab3Screen
import com.example.lab1.src.lab4.Lab4ListImage
import com.example.lab1.src.lab4.Lab4Login
import com.example.lab1.src.lab4.Lab4NoteList
import com.example.lab1.src.lab5.Lab5Chips
import com.example.lab1.src.lab5.Lab5LightControl
import com.example.lab1.src.lab5.Lab5Login
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "lab5-chips") {
                    composable("lab3"){
                        Lab3Screen(navController)
                    }
                    composable("lab4-login"){
                        Lab4Login(navController)
                    }
                    composable("lab4-list-image"){
                        Lab4ListImage(navController)
                    }
                    composable("lab4-note-list"){
                        Lab4NoteList(navController)
                    }
                    composable("lab5-login"){
                        Lab5Login(navController)
                    }
                    composable("lab5-light-control"){
                        Lab5LightControl(navController)
                    }
                    composable("lab5-chips"){
                        Lab5Chips(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name, modifier.then(Modifier.fillMaxWidth()),
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}