package com.example.monapplicationjeux

import com.example.monapplicationjeux.logic.ResultatPartie
import com.example.monapplicationjeux.logic.eliminerJoueur
import com.example.monapplicationjeux.logic.verifierResultat
import com.example.monapplicationjeux.model.Joueur
import com.example.monapplicationjeux.model.Role
import org.junit.Test
import org.junit.Assert.assertEquals

class LogiqueVoteTest {

    @Test
    fun `partie continue si plusieurs civils et un undercover en vie`() {
        val joueurs = listOf(
            Joueur("Lucas", role = Role.CIVIL),
            Joueur("Marie", role = Role.CIVIL),
            Joueur("Tom", role = Role.CIVIL),
            Joueur("Julie", role = Role.UNDERCOVER)
        )

        val resultat = verifierResultat(joueurs)
        assertEquals(ResultatPartie.EN_COURS, resultat)
    }

    @Test
    fun `victoire des civils quand tous les undercovers sont elimines`() {
        val joueurs = listOf(
            Joueur("Lucas", role = Role.CIVIL),
            Joueur("Marie", role = Role.CIVIL),
            Joueur("Julie", role = Role.UNDERCOVER, estElimine = true)
        )

        val resultat = verifierResultat(joueurs)
        assertEquals(ResultatPartie.VICTOIRE_CIVILS, resultat)
    }

    @Test
    fun `victoire de l'undercover quand il est a egalite avec les civils`() {
        val joueurs = listOf(
            Joueur("Lucas", role = Role.CIVIL),
            Joueur("Marie", role = Role.CIVIL, estElimine = true),
            Joueur("Julie", role = Role.UNDERCOVER)
        )

        val resultat = verifierResultat(joueurs)
        assertEquals(ResultatPartie.VICTOIRE_UNDERCOVER, resultat)
    }

    @Test
    fun `eliminer un joueur ne touche pas aux autres`() {
        val lucas = Joueur("Lucas", role = Role.CIVIL)
        val marie = Joueur("Marie", role = Role.UNDERCOVER)
        val joueurs = listOf(lucas, marie)

        val resultat = eliminerJoueur(joueurs, marie)

        val lucasResultat = resultat.first { it.nom == "Lucas" }
        val marieResultat = resultat.first { it.nom == "Marie" }

        assertEquals(false, lucasResultat.estElimine)
        assertEquals(true, marieResultat.estElimine)

        println("Lucas éliminé : ${lucasResultat.estElimine}")
        println("Marie éliminée : ${marieResultat.estElimine}")
    }
}