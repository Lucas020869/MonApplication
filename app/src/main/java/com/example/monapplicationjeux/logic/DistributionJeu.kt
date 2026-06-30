package com.example.monapplicationjeux.logic

import com.example.monapplicationjeux.model.BanqueDeMots
import com.example.monapplicationjeux.model.Joueur
import com.example.monapplicationjeux.model.Role

fun distribuerRoles(joueurs: List<Joueur>, nombreUndercover: Int): List<Joueur> {
    val paireChoisie = BanqueDeMots.paires.random()

    val joueursMelanges = joueurs.shuffled()

    val joueursMisAJour = joueursMelanges.mapIndexed { index, joueur ->
        if (index < nombreUndercover) {
            joueur.copy(
                role = Role.UNDERCOVER,
                mot = paireChoisie.motUndercover,
                estElimine = false
            )
        } else {
            joueur.copy(
                role = Role.CIVIL,
                mot = paireChoisie.motCivil,
                estElimine = false
            )
        }
    }

    return joueursMisAJour
}