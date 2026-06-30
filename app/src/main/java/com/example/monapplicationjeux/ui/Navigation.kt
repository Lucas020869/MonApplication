package com.example.monapplicationjeux.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monapplicationjeux.logic.distribuerRoles
import com.example.monapplicationjeux.model.EtatPartie
import com.example.monapplicationjeux.model.Joueur

@Composable
fun NavigationApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "accueil",
        modifier = modifier
    ) {
        composable("accueil") {
            EcranAccueil(onJouerClick = {
                navController.navigate("configuration")
            })
        }
        composable("configuration") {
            EcranConfiguration(onDemarrerClick = { noms, nombreUndercover ->
                val joueurs = noms.mapIndexed { index, nom ->
                    Joueur(nom = nom.ifBlank { "Joueur ${index + 1}" })
                }
                val joueursAvecRoles = distribuerRoles(joueurs, nombreUndercover)

                // Pour l'instant on stocke juste dans une variable globale temporaire
                // (on améliorera ça à l'étape suivante)
                EtatPartie.joueurs = joueursAvecRoles

                navController.navigate("jeu")
            })
        }
        composable("jeu") {
            EcranJeu(onReglesClick = {
                navController.navigate("regles")
            })
        }
        composable("regles") {
            EcranRegles(onRetourClick = {
                navController.popBackStack()
            })
        }
    }
}