package com.example.lab1.src.lab5

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.lab1.R
import com.example.lab1.src.lab4.Lab4Login

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lab5Login(navController: NavController) {
    val context = LocalContext.current
    var useName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var rememberUser by remember {
        mutableStateOf(false)
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    if (showDialog){
        val dialogMessage = if (useName.isEmpty() || password.isEmpty())
            "Please enter username and password"
        else
            "Login successfully"

        Dialog(onDismissRequest = { showDialog=false }) {
            Column (modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)){
                Text(text = dialogMessage, textAlign = TextAlign.Center)
                Button(onClick = { showDialog=false}) {
                    Text(text = "Confirm")
                }
            }
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
        .padding(20.dp),
        verticalArrangement = Arrangement.Center) {
        Card(modifier = Modifier
            .background(Color.White)
            .height(500.dp)
            .fillMaxWidth()) {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.DarkGray)
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
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)){
                    Switch(checked =rememberUser , onCheckedChange ={ rememberUser= it})
                    Text(text = "Remember Me?")
                }
                Button(onClick = {
                    showDialog = true
                }) {
                    Text(text = "Login")
                }

                Button(onClick = { navController.navigate("lab5-light-control")}) {
                    Text(text = "Goto Lab5 Light Control")
                }
            }
        }
    }
}