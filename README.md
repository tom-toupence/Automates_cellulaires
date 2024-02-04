# Projet Automates

## Introduction
Ce projet implémente et explore divers automates cellulaires, incluant les automates cellulaires 1D, un modèle de feu de forêt et les automates custom. L'objectif est d'étudier le comportement de ces modèles sous différentes règles et configurations.

### Contributeurs

- LARZUL Julien
- MONPRIVE Cédric
- TOUPENCE Tom

### Architecture du Projet

L'architecture de ce projet est organisée en plusieurs packages pour une clarté et une maintenabilité optimales :

#### Métier
Ce package contient les classes essentielles de la logique métier des automates cellulaires :
- `Automate1D` : Gestion des automates cellulaires 1D.
- `AutomateCellulaire` : Classe abstraite pour les comportements communs des automates.
- `AutomateCellulaire1D`, `AutomateCellulaire2D`, `AutomateCellulaire3D` : Implémentations pour chaque dimension.
- `Cellule` : Représentation d'une cellule individuelle.
- `FeuDeForet` : Simulation d'automate pour les feux de forêt.

#### Util
Ce package fournit des utilitaires et fonctionnalités supportant la logique métier :
- `Automate1D_info` et `Automate1D_results` : Gestion des entrées et des résultats pour l'automate 1D.
- `ColorAutomate1D` et `ColorAutomate2D` : Affichage coloré des états des automates.
- `Exit`, `FeuDeForetInfo`, `FeuDeForetResult`, `Parametres`, `RetournerMenu` : Outils pour la navigation et les configurations.

#### Window
Contient les classes de l'interface utilisateur :
- `WindowAutomate1D`, `WindowAutomate1DInfo` : Fenêtres pour l'automate 1D.
- `WindowFeuDeForet`, `WindowFeuDeForetInfo` : Fenêtres pour la simulation de feu de forêt.
- `WindowMain` : Fenêtre principale servant de menu.

#### Main
Point d'entrée initialisant l'interface utilisateur.

Chaque module est conçu pour être indépendant tout en collaborant avec les autres, permettant une évolution et une maintenance simplifiées.


### Fonctionnalités Principales

- **Automate 1D** : Implémentation des automates cellulaires 1D avec règles personnalisables.
- **Feu de Forêt** : Simulation de la propagation de feu de forêt avec de multiples paramètres réglables.
- **Automate custom** : Conception modulaire permettant une intégration facile d'automates supplémentaires.

---
