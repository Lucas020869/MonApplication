package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EcranAccueil(onJouerClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Bienvenue",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(top = 48.dp)
        )

        Button(
            onClick = onJouerClick,
            modifier = Modifier
                .padding(bottom = 48.dp)
                .width(220.dp)
                .height(70.dp)
        ) {
            Text(
                text = "Undercover",
                fontSize = 22.sp
            )
        }
    }
}