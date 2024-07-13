package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.src.components.Lab3Button
import com.example.lab1.ui.theme.Lab1Theme
import java.io.Console

class MainActivity : ComponentActivity() {
    init {
        
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                val text = remember {
                    mutableStateOf("Dao Huu Quan - PD09237")
                }
                val timer = remember{
                    mutableIntStateOf(1)
                }

                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 50.dp)){
                    ShowName(name = text.value)
                    Lab3Button(title = "QUan",
                        onClick = {
                            if (timer.value==1) {
                                text.value = "Hi !!!"
                            }else {
                                text.value = "You have clicked the button ${timer.value} times."
                            }
                            timer.value++
                        })
                }
            }
        }
    }
}

@Composable
fun ShowName(name:String, modifier: Modifier = Modifier) {
    Text(text = name, modifier.then(Modifier.fillMaxWidth()),
        fontSize = 20.sp,
        textAlign = TextAlign.Center)
}