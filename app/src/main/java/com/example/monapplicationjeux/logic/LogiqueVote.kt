package com.example.monapplicationjeux.logic

import com.example.monapplicationjeux.model.Joueur
import com.example.monapplicationjeux.model.Role

enum class ResultatPartie {
    EN_COURS,
    VICTOIRE_CIVILS,
    VICTOIRE_UNDERCOVER
}

fun eliminerJoueur(joueurs: List<Joueur>, joueurAEliminer: Joueur): List<Joueur> {
    return joueurs.map { joueur ->
        if (joueur == joueurAEliminer) {
            joueur.copy(estElimine = true)
        } else {
            joueur
        }
    }
}

fun verifierResultat(joueurs: List<Joueur>): ResultatPartie {
    val joueursEnVie = joueurs.filter { !it.estElimine }
    val undercoverEnVie = joueursEnVie.count { it.role == Role.UNDERCOVER }
    val civilsEnVie = joueursEnVie.count { it.role == Role.CIVIL }

    return when {
        undercoverEnVie == 0 -> ResultatPartie.VICTOIRE_CIVILS
        undercoverEnVie >= civilsEnVie -> ResultatPartie.VICTOIRE_UNDERCOVER
        else -> ResultatPartie.EN_COURS
    }
}