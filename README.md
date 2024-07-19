# Projet Blackjack avec Librairie de Cartes

Ce projet est constitué de deux parties principales : une librairie Java pour manipuler des cartes et un jeu de Blackjack utilisant cette librairie. Le projet suit l'architecture MVC (Modèle-Vue-Contrôleur) pour un découpage clair entre les différentes parties de l'application.

## Table des Matières

1. [Présentation](#présentation)
2. [Architecture Logicielle](#architecture-logicielle)
   - [Modèle de Conception](#modèle-de-conception)
3. [Prérequis](#prérequis)
4. [Compilation](#compilation)
5. [Exécution](#exécution)
6. [Utilisation](#utilisation)
7. [Exemples](#exemples)
8. [Contribution](#contribution)
9. [Licence](#licence)

## Présentation

### Librairie de Cartes

La librairie de cartes permet de créer et manipuler des cartes de jeux, avec une implémentation pour un jeu de 52 cartes classiques. Elle fournit également des fonctionnalités pour gérer des paquets de cartes et des mains de cartes, avec plusieurs vues possibles (cartes visibles, cachées, etc.).

**Fonctionnalités principales :**
- Création et manipulation de cartes.
- Gestion des paquets de cartes (ajout, retrait, mélange).
- Affichage des cartes avec différentes vues.

### Jeu de Blackjack

Le jeu de Blackjack utilise la librairie de cartes pour permettre au joueur de jouer contre des IA. Le jeu est implémenté en suivant les règles classiques du Blackjack, avec des fonctionnalités supplémentaires comme les splits et les assurances.

**Fonctionnalités principales :**
- Gestion du jeu de Blackjack avec règles classiques.
- IA pour jouer contre le joueur.
- Options avancées comme le split et l'assurance.

## Architecture Logicielle

Le projet utilise plusieurs modèles de conception pour assurer une architecture claire et modulaire. Voici trois modèles de conception clés appliqués :

### 1. **Modèle-Vue-Contrôleur (MVC)**

Le modèle MVC est utilisé pour séparer les préoccupations dans le jeu de Blackjack et la librairie de cartes. Ce modèle divise l'application en trois composants principaux :

- **Modèle** : Représente les données et la logique du jeu. Par exemple, la classe `Carte` gère les propriétés d'une carte et la classe `MainJeuBlackjack` gère la logique du jeu de Blackjack.
- **Vue** : Gère l'affichage des données à l'utilisateur. Les vues peuvent inclure des représentations graphiques des cartes et de l'état du jeu.
- **Contrôleur** : Gère les interactions entre le modèle et la vue. Il reçoit les entrées de l'utilisateur, met à jour le modèle, et envoie les mises à jour à la vue.

### 2. **Pattern Singleton**

Le pattern Singleton est utilisé pour garantir qu'une seule instance d'un objet existe et fournit un point d'accès global à cette instance. Dans le projet, ce modèle est appliqué pour gérer les configurations globales du jeu et l'état du paquet de cartes, comme la classe `JeuBlackjack`, qui assure qu'il n'y a qu'une seule instance du jeu en cours.

### 3. **Pattern Observer**

Le pattern Observer est utilisé pour notifier les vues lorsque l'état du modèle change. Ce modèle est appliqué pour mettre à jour l'affichage des cartes et du score en temps réel. Les objets Observer (comme les vues de cartes) s'abonnent aux changements dans les objets Observés (comme le modèle du jeu), permettant une mise à jour automatique de l'affichage lorsque le modèle change.

## Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés :

- **Java Development Kit (JDK) :** Assurez-vous d'avoir JDK 8 ou une version plus récente.

## Compilation

Pour compiler le projet, suivez ces étapes :

1. **Compiler la librairie de cartes :**
   - Compilez les fichiers source de la librairie de cartes.

   ```sh
   javac cartes/*.java
