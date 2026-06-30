package com.example.monapplicationjeux.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monapplicationjeux.logic.ResultatPartie
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
                EtatPartie.joueurs = joueursAvecRoles
                EtatPartie.nombreUndercover = nombreUndercover
                navController.navigate("jeu")
            })
        }
        composable("jeu") {
            EcranJeu(
                onReglesClick = { navController.navigate("regles") },
                onTousJoueursVus = { navController.navigate("vote") }
            )
        }
        composable("vote") {
            EcranVote(
                onReglesClick = { navController.navigate("regles") },
                onPartieTerminee = { resultat ->
                    navController.navigate("victoire/${resultat.name}")
                }
            )
        }
        composable("victoire/{resultat}") { backStackEntry ->
            val resultatText = backStackEntry.arguments?.getString("resultat") ?: "EN_COURS"
            val resultat = ResultatPartie.valueOf(resultatText)
            EcranVictoire(
                resultat = resultat,
                onRejouerMemesJoueursClick = {
                    val nomsJoueurs = EtatPartie.joueurs.map { it.nom }
                    val nouveauxJoueurs = nomsJoueurs.map { nom -> Joueur(nom = nom) }
                    val joueursAvecRoles = distribuerRoles(nouveauxJoueurs, EtatPartie.nombreUndercover)
                    EtatPartie.joueurs = joueursAvecRoles

                    navController.navigate("jeu") {
                        popUpTo("accueil") { inclusive = false }
                    }
                },
                onAccueilClick = {
                    navController.navigate("accueil") {
                        popUpTo("accueil") { inclusive = true }
                    }
                }
            )
        }
        composable("regles") {
            EcranRegles(onRetourClick = {
                navController.popBackStack()
            })
        }
    }
}