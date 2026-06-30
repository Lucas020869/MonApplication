package com.example.monapplicationjeux.model

enum class Role {
    CIVIL,
    UNDERCOVER
}

data class Joueur(
    val nom: String,
    var mot: String = "",
    var role: Role = Role.CIVIL,
    var estElimine: Boolean = false
)