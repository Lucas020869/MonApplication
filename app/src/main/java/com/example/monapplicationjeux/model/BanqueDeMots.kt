package com.example.monapplicationjeux.model

data class PaireMots(
    val motCivil: String,
    val motUndercover: String
)
object BanqueDeMots {
    val paires = listOf(
        // Animaux
        PaireMots("Chat", "Chien"),
        PaireMots("Cheval", "Zèbre"),
        PaireMots("Dauphin", "Requin"),
        PaireMots("Aigle", "Faucon"),
        PaireMots("Lapin", "Lièvre"),
        PaireMots("Abeille", "Guêpe"),
        PaireMots("Tigre", "Lion"),
        PaireMots("Girafe", "Zèbre"),
        PaireMots("Éléphant", "Rhinocéros"),
        PaireMots("Serpent", "Cobra"),

        // Nourriture
        PaireMots("Pizza", "Burger"),
        PaireMots("Café", "Thé"),
        PaireMots("Beurre", "Confiture"),
        PaireMots("Riz", "Pâtes"),
        PaireMots("Chocolat", "Vanille"),
        PaireMots("Citron", "Orange"),
        PaireMots("Fromage", "Yaourt"),
        PaireMots("Soupe", "Bouillon"),
        PaireMots("Pomme", "Poire"),
        PaireMots("Glace", "Sorbet"),
        PaireMots("Gâteau", "Tarte"),
        PaireMots("Boulangerie", "Pâtisserie"),
        PaireMots("Supermarché", "Marché"),

        // Métiers
        PaireMots("Docteur", "Infirmier"),
        PaireMots("Professeur", "Élève"),
        PaireMots("Policier", "Pompier"),
        PaireMots("Avocat", "Juge"),

        // Technologie
        PaireMots("Téléphone", "Tablette"),
        PaireMots("Internet", "Wifi"),
        PaireMots("Clavier", "Souris"),
        PaireMots("Télévision", "Radio"),
        PaireMots("Ordinateur fixe", "Ordinateur portable"),
        PaireMots("Caméra", "Photographie"),
        PaireMots("Télécommande", "Joystick"),
        PaireMots("Robot", "Machine"),
        PaireMots("Casque", "Écouteurs"),

        // Lieux
        PaireMots("Colline", "Montagne"),
        PaireMots("Forêt", "Jungle"),
        PaireMots("École", "Université"),
        PaireMots("Hôpital", "Clinique"),
        PaireMots("Restaurant", "Bar"),
        PaireMots("Maison", "Appartement"),
        PaireMots("Château", "Palais"),
        PaireMots("Jardin", "Potager"),
        PaireMots("Bureau", "Atelier"),
        PaireMots("Aéroport", "Gare"),
        PaireMots("Bibliothèque", "Médiathèque"),
        PaireMots("Banque", "Caisse"),
        PaireMots("Parc", "Jardin"),
        PaireMots("Musée", "Galerie"),

        // Objets du quotidien
        PaireMots("Parapluie", "Imperméable"),
        PaireMots("Valise", "Sac à dos"),
        PaireMots("Lit", "Canapé"),
        PaireMots("Lampe", "Spot"),
        PaireMots("Montre", "Bracelet"),
        PaireMots("Lunettes", "Verres"),
        PaireMots("Livre", "Magazine"),
        PaireMots("Stylo", "Crayon"),
        PaireMots("Papier", "Cahier"),
        PaireMots("Horloge", "Pendule"),
        PaireMots("Sac", "Valise"),
        PaireMots("Bracelet", "Collier"),
        PaireMots("Bague", "Anneau"),
        PaireMots("Parfum", "Déodorant"),

        // Sport
        PaireMots("Football", "Basketball"),
        PaireMots("Volleyball", "Tennis"),
        PaireMots("Natation", "Plongée"),
        PaireMots("Badminton", "Tennis"),
        PaireMots("Ski", "Snowboard"),
        PaireMots("Médaille", "Trophée"),

        // Transport
        PaireMots("Voiture", "Moto"),
        PaireMots("Train", "Tramway"),
        PaireMots("Avion", "Hélicoptère"),
        PaireMots("Vélo", "Trottinette"),
        PaireMots("Bateau", "Sous-marin"),
        PaireMots("Camion", "Fourgon"),
        PaireMots("Tracteur", "Pelleteuse"),
        PaireMots("Autoroute", "Boulevard"),

        // Nature / Météo
        PaireMots("Pluie", "Neige"),
        PaireMots("Soleil", "Lune"),
        PaireMots("Rivière", "Lac"),
        PaireMots("Vent", "Bourrasque"),
        PaireMots("Mer", "Océan"),
        PaireMots("Étoile", "Planète"),
        PaireMots("Fleuve", "Rivière"),
        PaireMots("Nuage", "Brume"),
        PaireMots("Feu", "Braise"),
        PaireMots("Sapin", "Érable"),
        PaireMots("Cactus", "Palmier"),
        PaireMots("Désert", "Savane"),
        PaireMots("Marais", "Brouillard"),
        PaireMots("Orage", "Ouragan"),
        PaireMots("Tornade", "Typhon"),
        PaireMots("Lac", "Étang"),
        PaireMots("Camping", "Bivouaque"),
        PaireMots("Piscine", "Jacuzzi"),

        // Vêtements et accessoires
        PaireMots("Pantalon", "Jean"),
        PaireMots("Chaussures", "Bottes"),
        PaireMots("Chemise", "Blouse"),
        PaireMots("Chapeau", "Casquette"),
        PaireMots("Écharpe", "Bonnet"),
        PaireMots("Gant", "Mitaines"),

        // Art et culture
        PaireMots("Cinéma", "Théâtre"),
        PaireMots("Musique", "Danse"),
        PaireMots("Piano", "Guitare"),
        PaireMots("Violon", "Saxophone"),
        PaireMots("Peinture", "Dessin"),
        PaireMots("Sculpture", "Statue"),
        PaireMots("Cirque", "Spectacle"),
        PaireMots("Théâtre", "Opéra"),

        // Villes
        PaireMots("Paris", "Londres"),

        // Espace / Sciences
        PaireMots("Fusée", "Satellite")
    )
}