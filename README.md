# 📦 Stock Management App  
Spring MVC - Spring Data JPA & Spring Security

## 📖 Description
Application web de gestion de stock développée avec **Spring Boot**.  
Elle permet de gérer des produits (CRUD) avec un système de sécurité basé sur **Spring Security** (authentification, rôles, autorisations).

---

## 🚀 Fonctionnalités

- Authentification sécurisée (Spring Security)
- Gestion des rôles (USER / ADMIN)
- CRUD des produits
- Recherche par nom
- Pagination des données
- Interface responsive avec Bootstrap
- Messages de notification (succès, modification, suppression)

---

## 🔐 Sécurité

- Authentification In-Memory
- Mots de passe encodés avec BCrypt
- Protection CSRF activée
- Gestion des accès par rôles :

| Route       | Accès              |
|------------|-------------------|
| /admin/**  | ADMIN uniquement  |
| /user/**   | USER & ADMIN      |
| /login     | Public            |

---

## 🛠️ Technologies

**Backend**
- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security

**Frontend**
- Thymeleaf
- Bootstrap 5

**Database**
- H2 (in-memory)

---

## ▶️ Lancer le projet

```bash
mvn spring-boot:run

Accès :
http://localhost:8094/login

👤 Comptes de test
Username	Password	Role
user1	1234	USER
user2	1234	USER
admin	1234	ADMIN
👩‍💻 Auteur

Aya Agrigah
