package com.example.lab1.src.lab5

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lab5Chips(navController: NavController) {
    val categories = listOf(
        "Fiction", "Mystery", "Science", "Fantasy", "Adventure", "Historical", "Horror",
        "Romance"
    )
    val suggestions = listOf(
        "Biography", "Cookbook", "Poetry",
        "Self-help", "Thriller"
    )
    var selected by remember {
        mutableStateOf(setOf<String>())
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Categories(
            list = categories,
            selectedList = selected
        ) {
            selected = selected.plus(it)
        }
        Suggestion(
            list = suggestions,
            selectedList = selected
        ) {
            selected = selected.plus(it)
        }
        SelectedList(list = selected) {
            selected = selected.minus(it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(
    modifier: Modifier = Modifier,
    title: String = "Choose categories:",
    list: List<String>,
    selectedList: Set<String>,
    onSelected: (String) -> Unit
) {
    Column {
        Text(text = title)
        Row(
            modifier.then(Modifier.horizontalScroll(rememberScrollState())),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            list.forEach {
                FilterChip(
                    selected = selectedList.contains(it),
                    onClick = { onSelected(it) },
                    label = {
                        Text(
                            text = it
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun Suggestion(
    modifier: Modifier = Modifier,
    title: String = "Suggestion:",
    list: List<String>,
    selectedList: Set<String>,
    onSelected: (String) -> Unit
) {
    Column {
        Text(text = title)
        Row(
            modifier.then(Modifier.horizontalScroll(rememberScrollState())),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            list.forEach {
                SuggestionChip(
                    onClick = { onSelected(it) },
                    label = { Text(text = it) },
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = if (selectedList.contains(it)) Color.LightGray else Color.White,
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedList(
    modifier: Modifier = Modifier,
    title: String = "Selected Categories:",
    list: Set<String>,
    onRemoveSelected: (String) -> Unit
) {
    Column {
        Text(text = title)
        Row(
            modifier.then(Modifier.horizontalScroll(rememberScrollState())),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
        list.forEach {
            InputChip(
                selected = true,
                onClick = { onRemoveSelected(it)},
                label = { Text(text = it) },
                trailingIcon = { Icon(imageVector = Icons.Filled.Clear, contentDescription = null)}
            )

        }}
    }
}