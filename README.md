📦 Activité Pratique N°2 : Spring MVC - Spring Data JPA & Spring Security
📖 Description du Projet

Ce projet consiste à développer une application web de gestion de stock de produits en utilisant Spring Boot et Spring MVC, avec un accent particulier sur la sécurisation de l’application via Spring Security.

L’objectif principal de ce travail pratique est d’illustrer les mécanismes fondamentaux de sécurité dans les applications web modernes, notamment :

🔐 Authentification des utilisateurs
🛡️ Gestion des rôles et autorisations (RBAC)
⚠️ Protection contre les attaques courantes
🔗 Sécurisation des routes HTTP

L’interface utilisateur est développée avec Thymeleaf et Bootstrap, permettant de créer une application dynamique, responsive et ergonomique.

🛠️ Technologies Utilisées
🔙 Backend
Java 17+
Spring Boot
Spring MVC
Spring Data JPA
Hibernate
Spring Security
Spring Validation
🎨 Frontend
Thymeleaf
Thymeleaf Layout Dialect
Thymeleaf Security Extras
HTML5 / CSS3
Bootstrap 5
Bootstrap Icons
🗄️ Base de données
H2 Database (base en mémoire)
⚙️ Outils de développement
Maven
IntelliJ IDEA
Git / GitHub
🔐 Sécurité et Contrôle d’Accès (Spring Security)

L'application implémente un système complet de sécurité basé sur Spring Security.

🔑 Authentification
Authentification In-Memory
Encodage des mots de passe avec BCryptPasswordEncoder
👥 Gestion des rôles (RBAC)
🔹 USER

Peut :

consulter la liste des produits
effectuer des recherches
🔹 ADMIN

Peut :

consulter les produits
ajouter un produit
modifier un produit
supprimer un produit
🔗 Sécurisation des routes
Route	Accès
/admin/**	ADMIN uniquement
/user/**	USER & ADMIN
/login	Public
🛡️ Protection CSRF
Activée par défaut pour sécuriser les formulaires et requêtes sensibles.
🚫 Gestion des exceptions
Accès non autorisé → redirection vers une page personnalisée (403 / notAuthorized)
📦 Gestion des Produits (CRUD)
➕ Create – Ajouter un produit
Formulaire sécurisé
Validation côté serveur avec :
@Valid
BindingResult
📖 Read – Afficher les produits
Tableau dynamique
Pagination
Interface responsive avec Bootstrap
✏️ Update – Modifier un produit
Formulaire pré-rempli
Utilisation d’un champ caché pour l’ID
❌ Delete – Supprimer un produit
Confirmation JavaScript avant suppression
🔍 Recherche de produits
Recherche par nom
Implémentée avec Spring Data JPA
🎨 Interface Utilisateur (UI / UX)
🧩 Système de Layout

Utilisation de Thymeleaf Layout Dialect pour :

un layout principal
des vues dynamiques réutilisables

Composants partagés :

Navbar
Footer
Styles globaux
📊 Barre de Navigation Dynamique
Affiche :
utilisateur connecté
options selon rôle
bouton logout

👉 Grâce à Thymeleaf Security Extras

🔔 Notifications (Flash Messages)

Affichage de messages Bootstrap :

ajout réussi
modification réussie
suppression réussie

Implémentation avec :

RedirectAttributes
🎯 Design

Interface réalisée avec Bootstrap :

Cards
Badges
Tables responsives
table-hover
Effets shadow

Objectif :
👉 Interface claire, moderne et intuitive

⚙️ Configuration Technique
🔹 H2 Console (dev)
Accessible pour tests
Configuration spéciale :
désactivation partielle CSRF
autorisation des frames

👉 Évite les erreurs liées au clickjacking

🧪 Tests de l’Application

L’application permet de tester :

authentification
restrictions d’accès
fonctionnalités CRUD selon les rôles
👤 Comptes de test
Username	Password	Role
user1	1234	USER
user2	1234	USER
admin	1234	ADMIN
▶️ Lancement du projet
Avec Maven
mvn spring-boot:run
Accès
http://localhost:8094/login
👩‍💻 Auteur

Aya Agrigah
ENSET – Spring MVC Practical Work
