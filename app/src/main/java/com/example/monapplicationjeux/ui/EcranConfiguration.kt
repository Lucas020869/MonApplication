package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EcranConfiguration(onDemarrerClick: (List<String>, Int) -> Unit) {

    var nombreJoueurs by remember { mutableStateOf(3) }
    var nombreUndercover by remember { mutableStateOf(1) }
    val nomsJoueurs = remember { mutableStateListOf("", "", "") }

    fun ajusterListeNoms() {
        while (nomsJoueurs.size < nombreJoueurs) nomsJoueurs.add("")
        while (nomsJoueurs.size > nombreJoueurs) nomsJoueurs.removeAt(nomsJoueurs.lastIndex)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Nombre de joueurs")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (nombreJoueurs > 3) {
                    nombreJoueurs--
                    ajusterListeNoms()
                    if (nombreUndercover >= nombreJoueurs) nombreUndercover = nombreJoueurs - 1
                }
            }) {
                Text("-")
            }
            Text("$nombreJoueurs", modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = {
                nombreJoueurs++
                ajusterListeNoms()
            }) {
                Text("+")
            }
        }

        Text("Nombre d'undercovers", modifier = Modifier.padding(top = 16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (nombreUndercover > 1) nombreUndercover--
            }) {
                Text("-")
            }
            Text("$nombreUndercover", modifier = Modifier.padding(horizontal = 16.dp))
            Button(onClick = {
                if (nombreUndercover < nombreJoueurs - 1) nombreUndercover++
            }) {
                Text("+")
            }
        }

        Text("Noms des joueurs", modifier = Modifier.padding(top = 16.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(nomsJoueurs.size) { index ->
                OutlinedTextField(
                    value = nomsJoueurs[index],
                    onValueChange = { nomsJoueurs[index] = it },
                    label = { Text("Joueur ${index + 1}") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }

        Button(
            onClick = { onDemarrerClick(nomsJoueurs.toList(), nombreUndercover) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Démarrer la partie")
        }
    }
}