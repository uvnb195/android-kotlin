package com.example.lab1.src.lab4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Lab4NoteList(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Add, contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            intArrayOf(1,2,3,4,5,6).forEach {
                NoteItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Note $it"
                )
            }
        }
    }
}

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray)
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,
            fontWeight = FontWeight.Bold)
        Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = null,
            modifier= Modifier.size(32.dp))
    }
}