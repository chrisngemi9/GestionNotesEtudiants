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

        // 4. Trier par moyenne décroissante (meilleur au moins bon)
        etudiants.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));

        // 5. Afficher le classement final
        System.out.println("\n=== Classement final (meilleur au moins bon) ===");
        for (int i = 0; i < etudiants.size(); i++) {
            System.out.println((i + 1) + ". " + etudiants.get(i));
        }

        // 6. Sauvegarder les résultats
        System.out.println("\n=== Sauvegarde des résultats ===");
        sauvegarderResultats(etudiants, "data/resultats.csv");
    }

    /**
     * Sauvegarde les résultats triés dans un fichier CSV.
     * Format : rang,nom,moyenne
     */
    private static void sauvegarderResultats(List<Etudiant> etudiants, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {

            writer.write("rang,nom,moyenne");
            writer.newLine();

            for (int i = 0; i < etudiants.size(); i++) {
                Etudiant e = etudiants.get(i);
                writer.write((i + 1) + "," + e.getNom() + "," + String.format("%.2f", e.getMoyenne()));
                writer.newLine();
            }

            System.out.println("Résultats sauvegardés dans : " + cheminFichier);

        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
