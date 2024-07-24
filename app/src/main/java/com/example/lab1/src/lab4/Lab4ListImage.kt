package com.example.lab1.src.lab4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab1.R

@Composable
fun Lab4ListImage(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.DarkGray)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 20.dp)
            .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            for (item in intArrayOf(1,2,3,4,5)){
                CustomImage()
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(top = 20.dp)
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            for (item in intArrayOf(1,2,3,4,5)){
                CustomImage(modifier = Modifier.background(Color.Magenta))
            }
        }
        Button(onClick = { navController.navigate("lab4-note-list") }) {
            Text(text = "Go to Lab4 NoteList")
        }
    }
}

@Composable
fun CustomImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Cyan)
            .size(200.dp)
            .then(modifier)
    )
}