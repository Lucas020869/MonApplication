package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.monapplicationjeux.model.EtatPartie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranJeu(onReglesClick: () -> Unit) {

    val joueurs = EtatPartie.joueurs
    var indexJoueurActuel by remember { mutableIntStateOf(0) }
    var motVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    Button(onClick = onReglesClick) {
                        Text("Règles")
                    }
                }
            )
        }
    ) { innerPadding ->

        if (joueurs.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("Aucune partie en cours")
            }
            return@Scaffold
        }

        if (indexJoueurActuel >= joueurs.size) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text("Tous les joueurs ont vu leur mot. Phase de vote à venir.")
            }
            return@Scaffold
        }

        val joueurActuel = joueurs[indexJoueurActuel]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (!motVisible) {
                Text(
                    text = "Passe le téléphone à",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = joueurActuel.nom,
                    style = MaterialTheme.typography.headlineMedium
                )

                Button(
                    onClick = { motVisible = true },
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text("Voir mon mot")
                }
            } else {
                Text(
                    text = "Ton mot est :",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = joueurActuel.mot,
                    style = MaterialTheme.typography.headlineLarge
                )

                Button(
                    onClick = {
                        motVisible = false
                        indexJoueurActuel++
                    },
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text("J'ai vu, suivant")
                }
            }
        }
    }
}