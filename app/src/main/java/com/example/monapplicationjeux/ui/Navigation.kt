package com.example.monapplicationjeux.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier

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