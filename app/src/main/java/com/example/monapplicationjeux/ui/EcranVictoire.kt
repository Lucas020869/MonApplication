package com.example.monapplicationjeux.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.monapplicationjeux.logic.ResultatPartie
import com.example.monapplicationjeux.model.EtatPartie
import com.example.monapplicationjeux.model.Role

@Composable
fun EcranVictoire(
    resultat: ResultatPartie,
    onRejouerMemesJoueursClick: () -> Unit,
    onAccueilClick: () -> Unit
) {

    val texteResultat = when (resultat) {
        ResultatPartie.VICTOIRE_CIVILS -> "Les Civils ont gagné !"
        ResultatPartie.VICTOIRE_UNDERCOVER -> "Les Undercovers ont gagné !"
        ResultatPartie.EN_COURS -> "Partie en cours"
    }

    val roleGagnant = when (resultat) {
        ResultatPartie.VICTOIRE_CIVILS -> Role.CIVIL
        ResultatPartie.VICTOIRE_UNDERCOVER -> Role.UNDERCOVER
        ResultatPartie.EN_COURS -> null
    }

    val nomsGagnants = EtatPartie.joueurs
        .filter { it.role == roleGagnant }
        .map { it.nom }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = texteResultat,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = nomsGagnants.joinToString(", "),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = onRejouerMemesJoueursClick,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Rejouer avec les mêmes joueurs")
        }

        Button(
            onClick = onAccueilClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Retour à l'accueil")
        }
    }
}