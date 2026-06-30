package com.example.monapplicationjeux.model

data class PaireMots(
    val motCivil: String,
    val motUndercover: String
)
object BanqueDeMots {
    val paires = listOf(
        PaireMots("Chien", "Loup"),
        PaireMots("Café", "Thé"),
        PaireMots("Pizza", "Tarte"),
        PaireMots("Médecin", "Infirmier"),
        PaireMots("Téléphone", "Ordinateur"),
        PaireMots("Plage", "Piscine")
    )
}