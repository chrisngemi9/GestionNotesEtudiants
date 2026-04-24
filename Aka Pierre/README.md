# Partie Individuelle : Tri et Restitution des Résultats
**Développeur :** Aka Pierre

## Missions réalisées
Dans le cadre de ce projet d'équipe, j'ai pris en charge la phase finale du traitement des données :

1.  **Algorithme de Tri** : Implémentation d'un comparateur personnalisé pour classer les étudiants par ordre décroissant (du premier au dernier) selon leur moyenne.
2.  **Affichage Console** : Formatage des données pour une lecture claire dans le terminal avec gestion de la précision décimale (2 chiffres après la virgule).
3.  **Sauvegarde des données** : Création d'un système d'exportation automatique vers un fichier externe (`resultats_final.txt`).

## Détails techniques
*   **Technologie utilisée** : Java (Collections Framework).
*   **Méthode de tri** : Utilisation d'une expression Lambda `(e1, e2) -> Double.compare(...)` pour optimiser la performance et la lisibilité du code.
*   **Gestion des fichiers** : Utilisation des classes `FileWriter` et `PrintWriter` avec un bloc `try-with-resources` pour garantir la sécurité de l'écriture et la fermeture du flux.

## Comment tester ma partie
1.  Ouvrir le projet dans **IntelliJ**.
2.  Lancer la classe `Main.java`.
3.  Le classement s'affichera dans la console.
4.  Un fichier nommé `resultats_final.txt` sera généré à la racine avec le rapport complet.
