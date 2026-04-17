package model;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String nom;
    private List<Double> notes;
    private double moyenne;

    public Etudiant(String nom) {
        this.nom = nom;
        this.notes = new ArrayList<>();
        this.moyenne = 0.0;
    }

    public String getNom() {
        return nom;
    }

    public List<Double> getNotes() {
        return notes;
    }

    public void ajouterNote(double note) {
        this.notes.add(note);
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public void calculerMoyenne() {
        if (notes.isEmpty()) {
            moyenne = 0.0;
            return;
        }
        double somme = 0.0;
        for (double note : notes) {
            somme += note;
        }
        moyenne = somme / notes.size();
    }

    @Override
    public String toString() {
        return nom + " : " + String.format("%.2f", moyenne);
    }
}
