package io;

import model.Etudiant;
import java.io.*;
import java.util.*;

/**
 * Classe responsable de la lecture du fichier CSV.
 * Lit toutes les notes de chaque étudiant (pas seulement la première).
 */
public class CsvReader {

    public static List<Etudiant> lireFichier(String chemin) throws IOException {
        Map<String, Etudiant> mapEtudiants = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            boolean premiereLigne = true;

            while ((ligne = br.readLine()) != null) {

                // Sauter l'en-tête
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }

                // Ignorer les lignes vides
                if (ligne.trim().isEmpty()) continue;

                String[] colonnes = ligne.split("[,;]");
                if (colonnes.length < 3) {
                    System.err.println("Ligne ignorée (format incorrect) : " + ligne);
                    continue;
                }

                String nom = colonnes[0].trim();

                // Lire TOUTES les notes (colonne 2 et suivantes)
                Etudiant etudiant = mapEtudiants.get(nom);
                if (etudiant == null) {
                    etudiant = new Etudiant(nom);
                    mapEtudiants.put(nom, etudiant);
                }

                for (int i = 2; i < colonnes.length; i++) {
                    try {
                        double note = Double.parseDouble(colonnes[i].trim());
                        etudiant.ajouterNote(note);
                    } catch (NumberFormatException e) {
                        System.err.println("Note invalide pour " + nom + " : " + colonnes[i] + " -> ignorée");
                    }
                }
            }
        }

        return new ArrayList<>(mapEtudiants.values());
    }
}
