import model.Etudiant;
import io.CsvReader;
import service.NoteCalculator;

import java.io.*;
import java.util.*;

/**
 * Point d'entrée du programme de gestion des notes des étudiants.
 * Ce programme :
 *   1. Lit les étudiants depuis un fichier CSV
 *   2. Calcule la moyenne de chaque étudiant
 *   3. Trie les étudiants par moyenne décroissante
 *   4. Affiche le classement dans la console
 *   5. Sauvegarde les résultats dans un fichier CSV
 */
public class Main {

    public static void main(String[] args) {

        // 1. Lire le fichier CSV
        System.out.println("=== Chargement des étudiants ===");
        List<Etudiant> etudiants;

        try {
            etudiants = CsvReader.lireFichier("data/etudiants.csv");
        } catch (IOException e) {
            System.out.println("Erreur : impossible de lire le fichier CSV. " + e.getMessage());
            return;
        }

        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant trouvé. Vérifiez le fichier CSV.");
            return;
        }

        System.out.println(etudiants.size() + " étudiant(s) chargé(s).\n");

        // 2. Calculer les moyennes
        NoteCalculator.calculerToutesLesMoyennes(etudiants);

        // 3. Afficher avant le tri
        System.out.println("=== Liste avant tri ===");
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

        // 4. Trier par moyenne décroissante via Outils
        Outils.trierParMoyenne(etudiants);

        // 5. Afficher le classement final
        System.out.println("\n=== Classement final (meilleur au moins bon) ===");
        for (int i = 0; i < etudiants.size(); i++) {
            System.out.println((i + 1) + ". " + etudiants.get(i));
        }

        // 6. Sauvegarder les résultats via Outils
        System.out.println("\n=== Sauvegarde des résultats ===");
        Outils.sauvegarderResultats(etudiants, "data/resultats.csv");
    }
}
