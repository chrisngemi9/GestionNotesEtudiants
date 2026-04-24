import java.io.*;
import java.util.*;

// 1. DÉFINITION DE L'OBJET ETUDIANT
class Etudiant {
    private String nom;
    private double moyenne;

    public Etudiant(String nom, double moyenne) {
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public String getNom() { return nom; }
    public double getMoyenne() { return moyenne; }
}

// 2. CLASSE PRINCIPALE
public class Main {
    public static void main(String[] args) {
        System.out.println("Programme de gestion des notes prêt.");


        List<Etudiant> testListe = new ArrayList<>();
        testListe.add(new Etudiant("Alice", 15.5));
        testListe.add(new Etudiant("Bob", 18.0));

        GestionnaireResultats gestionnaire = new GestionnaireResultats();
        gestionnaire.traiterResultats(testListe);
    }
}

// 3.  PARTIE : TRI, AFFICHAGE ET SAUVEGARDE
class GestionnaireResultats {

    public void traiterResultats(List<Etudiant> listeEtudiants) {
        String nomFichier = "resultats_final.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomFichier))) {

            // TRI : du plus haut au plus bas
            listeEtudiants.sort((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));

            System.out.println("\n--- CLASSEMENT DES ÉTUDIANTS ---");
            writer.println("CLASSEMENT FINAL :");

            for (int i = 0; i < listeEtudiants.size(); i++) {
                Etudiant e = listeEtudiants.get(i);
                String ligne = String.format("%d. %s [Moyenne: %.2f]", (i + 1), e.getNom(), e.getMoyenne());

                System.out.println(ligne);
                writer.println(ligne);
            }

            System.out.println("\n=> Sauvegarde réussie dans : " + nomFichier);

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
