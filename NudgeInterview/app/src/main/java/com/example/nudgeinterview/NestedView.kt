package com.example.nudgeinterview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NestedViewWithClickListeners() {

    var outerClickMessageState by remember { mutableStateOf("")}

    var innerClickMessageState by remember { mutableStateOf("")}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                outerClickMessageState = "Outer click message"
            }
    )  {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "")

            Button(
                onClick = {
                    innerClickMessageState = "innerclick message"
                },
                modifier = Modifier.background(Color.Black)
            ) {

            }
        }
    }
}