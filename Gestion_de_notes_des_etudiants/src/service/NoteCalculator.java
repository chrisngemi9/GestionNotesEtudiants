package service;

import model.Etudiant;
import java.util.List;

public class NoteCalculator {

    public static void calculerToutesLesMoyennes(List<Etudiant> etudiants) {
        for (Etudiant e : etudiants) {
            e.calculerMoyenne();
        }
    }
}
