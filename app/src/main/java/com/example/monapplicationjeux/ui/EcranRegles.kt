package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranRegles(onRetourClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Règles du jeu") },
                navigationIcon = {
                    IconButton(onClick = onRetourClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
        ) {
            Text(
                text = "Chaque joueur reçoit un mot. Les civils ont tous le même mot, " +
                        "tandis que le ou les undercover(s) ont un mot légèrement différent. " +
                        "À tour de rôle, chaque joueur décrit son mot sans le dire directement. " +
                        "Ensuite, tout le monde vote pour éliminer celui qu'il pense être l'undercover. " +
                        "Les civils gagnent s'ils éliminent tous les undercovers. " +
                        "Les undercovers gagnent s'ils survivent jusqu'à être à égalité ou en majorité.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}