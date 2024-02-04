# Projet Automates

## Introduction

Ce projet met en œuvre et explore divers automates cellulaires, y compris les automates cellulaires 1D, un modèle de simulation de feu de forêt, et des automates personnalisés. L'objectif est d'étudier le comportement de ces modèles sous différentes règles et configurations.

## Contributeurs

- Julien LARZUL
- Cédric MOMPRIVE
- Tom TOUPENCE

## Architecture du Projet

L'architecture de ce projet est organisée en plusieurs packages pour une clarté et une maintenabilité optimales :

### Métier

Ce package contient les classes centrales de la logique métier des automates cellulaires :

- `Automate1D` : Gère les automates cellulaires 1D.
- `AutomateCellulaire` : Classe abstraite pour les comportements communs des automates.
- `AutomateCellulaire1D`, `AutomateCellulaire2D` : Implémentations spécifiques pour chaque dimension.
- `Cellule` : Représentation d'une cellule individuelle.
- `FeuDeForet` : Simulation d'automate pour les feux de forêt.

### Util (Utilitaires)

Ce package fournit des utilitaires et des fonctionnalités qui soutiennent la logique métier :

- `Automate1D_info` et `Automate1D_results` : Gestion des entrées et des résultats pour l'automate 1D.
- `ColorAutomate1D` et `ColorAutomate2D` : Affichage en couleur des états des automates.
- `Exit`, `FeuDeForetInfo`, `FeuDeForetResult`, `Parametres`, `RetournerMenu` : Outils pour la navigation et les configurations.

### Window (Interface Utilisateur)

Contient les classes pour l'interface utilisateur :

- `WindowAutomate1D`, `WindowAutomate1DInfo` : Fenêtres pour l'automate 1D.
- `WindowFeuDeForet`, `WindowFeuDeForetInfo` : Fenêtres pour la simulation de feu de forêt.
- `WindowMain` : Fenêtre principale qui sert de menu.

### Main

Le point d'entrée initial qui initialise l'interface utilisateur.

Chaque module est conçu pour être indépendant tout en collaborant avec les autres, permettant ainsi une évolution et une maintenance simplifiées.

## Fonctionnalités Principales

- **Automate 1D** : Implémentation des automates cellulaires 1D avec des règles personnalisables.
- **Feu de Forêt** : Simulation de la propagation d'un feu de forêt avec de nombreux paramètres ajustables.
- **Automate Custom** : Conception modulaire permettant une intégration facile d'automates supplémentaires.

