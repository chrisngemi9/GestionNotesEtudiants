import model.Etudiant;
import java.io.*;
import java.util.*;

/**
 * Classe utilitaire contenant les méthodes de tri et de sauvegarde.
 */
public class Outils {

    /**
     * Trie les étudiants par moyenne décroissante (meilleur en premier).
     * Utilise un tri à bulles.
     */
    public static void trierParMoyenne(List<Etudiant> etudiants) {
        for (int i = 0; i < etudiants.size() - 1; i++) {
            for (int j = i + 1; j < etudiants.size(); j++) {
                if (etudiants.get(j).getMoyenne() > etudiants.get(i).getMoyenne()) {
                    // Échanger les deux étudiants
                    Etudiant temp = etudiants.get(i);
                    etudiants.set(i, etudiants.get(j));
                    etudiants.set(j, temp);
                }
            }
        }
    }

    /**
     * Sauvegarde les résultats triés dans un fichier CSV.
     * Format : rang,nom,moyenne
     */
    public static void sauvegarderResultats(List<Etudiant> etudiants, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {

            writer.write("rang,nom,moyenne");
            writer.newLine();

            for (int i = 0; i < etudiants.size(); i++) {
                Etudiant e = etudiants.get(i);
                writer.write((i + 1) + "," + e.getNom() + ","
                        + String.format("%.2f", e.getMoyenne()));
                writer.newLine();
            }

            System.out.println("Résultats sauvegardés dans : " + cheminFichier);

        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
