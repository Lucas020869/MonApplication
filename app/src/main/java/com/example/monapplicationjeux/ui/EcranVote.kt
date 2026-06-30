package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.monapplicationjeux.logic.ResultatPartie
import com.example.monapplicationjeux.logic.eliminerJoueur
import com.example.monapplicationjeux.logic.verifierResultat
import com.example.monapplicationjeux.model.EtatPartie
import com.example.monapplicationjeux.model.Joueur

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranVote(onReglesClick: () -> Unit, onPartieTerminee: (ResultatPartie) -> Unit) {

    var joueurs by remember { mutableStateOf(EtatPartie.joueurs) }
    var joueurElimine by remember { mutableStateOf<Joueur?>(null) }

    val joueursEnVie = joueurs.filter { !it.estElimine }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            Text(
                text = "Qui éliminez-vous ?",
                style = MaterialTheme.typography.headlineSmall
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                items(joueursEnVie.size) { index ->
                    val joueur = joueursEnVie[index]
                    Button(
                        onClick = { joueurElimine = joueur },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(joueur.nom)
                    }
                }
            }
        }

        val cible = joueurElimine
        if (cible != null) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Élimination de ${cible.nom}") },
                text = {
                    Text("${cible.nom} était : ${if (cible.role.name == "UNDERCOVER") "Undercover" else "Civil"}")
                },
                confirmButton = {
                    Button(onClick = {
                        val nouvelleListe = eliminerJoueur(joueurs, cible)
                        joueurs = nouvelleListe
                        EtatPartie.joueurs = nouvelleListe
                        joueurElimine = null

                        val resultat = verifierResultat(nouvelleListe)
                        if (resultat != ResultatPartie.EN_COURS) {
                            onPartieTerminee(resultat)
                        }
                    }) {
                        Text("Continuer")
                    }
                }
            )
        }
    }
}