package com.example.monapplicationjeux

import com.example.monapplicationjeux.logic.distribuerRoles
import com.example.monapplicationjeux.model.Joueur
import com.example.monapplicationjeux.model.Role
import org.junit.Test
import org.junit.Assert.assertEquals

class DistributionJeuTest {

    @Test
    fun `distribution attribue le bon nombre d'undercovers`() {
        val joueurs = listOf(
            Joueur("Lucas"),
            Joueur("Marie"),
            Joueur("Tom"),
            Joueur("Julie")
        )

        val resultat = distribuerRoles(joueurs, nombreUndercover = 1)

        val nombreUndercoverTrouve = resultat.count { it.role == Role.UNDERCOVER }
        val nombreCivilTrouve = resultat.count { it.role == Role.CIVIL }

        assertEquals(1, nombreUndercoverTrouve)
        assertEquals(3, nombreCivilTrouve)

        resultat.forEach { joueur ->
            println("${joueur.nom} -> ${joueur.role} -> mot: ${joueur.mot}")
        }
    }
}