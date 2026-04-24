# GestionNotesEtudiants
# Projet 1 — Gestion de notes des étudiants

## Membres
- Christophe
- AKA

## Description
Programme Java permettant de gérer les étudiants, leurs cours et leurs notes à partir d'un fichier CSV.

## Fonctionnalités
- Lecture d'un fichier CSV contenant les étudiants et leurs notes
- Calcul automatique de la moyenne de chaque étudiant
- Classement des étudiants par moyenne (meilleur → moins bon)
- Sauvegarde des résultats dans un fichier CSV

## Structure du projet
```
projet1/
├── README.md
├── contributions.txt
├── data/
│   ├── etudiants.csv       ← fichier d'entrée
│   └── resultats.csv       ← généré automatiquement à l'exécution
├── src/
│   ├── Main.java           ← point d'entrée du programme
│   ├── Etudiant.java       ← classe représentant un étudiant
│   └── Outils.java         ← lecture CSV, tri, sauvegarde
├── Christophe/
│   └── README.txt
└── AKA/
    └── README.txt
```

## Instructions d'exécution

### 1. Compiler
```bash
javac -d out src/Etudiant.java src/Outils.java src/Main.java
```

### 2. Exécuter
```bash
java -cp out Main
```

### 3. Résultat attendu
Le programme affiche le classement dans la console et génère le fichier `data/resultats.csv`.

## Format du fichier CSV d'entrée
```
nom,cours,note1,note2,note3
Alice,Mathématiques,85,90,78
Bob,Informatique,72,68,75
```
