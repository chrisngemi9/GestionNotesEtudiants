package io;

import model.Etudiant;
import java.io.*;
import java.util.*;

public class CsvReader {

    public static List<Etudiant> lireFichier(String chemin) throws IOException {
        Map<String, Etudiant> mapEtudiants = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            boolean premiereLigne = true;

            while ((ligne = br.readLine()) != null) {
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }

                String[] colonnes = ligne.split(",");
                if (colonnes.length < 3) {
                    System.err.println("Ligne ignorée (format incorrect) : " + ligne);
                    continue;
                }

                String nom = colonnes[0].trim();
                double note;
                try {
                    note = Double.parseDouble(colonnes[2].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Note invalide pour " + nom + " : " + colonnes[2] + " -> ignorée");
                    continue;
                }

                Etudiant etudiant = mapEtudiants.get(nom);
                if (etudiant == null) {
                    etudiant = new Etudiant(nom);
                    mapEtudiants.put(nom, etudiant);
                }
                etudiant.ajouterNote(note);
            }
        }

        return new ArrayList<>(mapEtudiants.values());
    }
}
