package com.example.lab1.src.lab4

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab1.R

@Composable
fun Lab4Login(navController: NavController) {
    val context = LocalContext.current
    var useName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.background(Color.DarkGray)
        )
        OutlinedTextField(
            value = useName,
            onValueChange = { useName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Use Name")}
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
            if (password.isEmpty() || useName.isEmpty())
                Toast.makeText(context,"Please enter usename and password",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context,"Login successful",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Login")
        }
        
        Button(onClick = { navController.navigate("lab4-list-image")}) {
            Text(text = "Goto Lab4 List Image")
        }
    }
}