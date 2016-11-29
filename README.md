# ProxiBanqueV3
*******************************************************
Proxybanque V3 - Mathilde & Claire - 29 novembre 2016
*******************************************************
---------------
Java resources
--------------
- com.proxibanque3.controller
	-	ConseillerController.java
	-	CompteController.java

- com.proxibanque3.dao
	- DaoClient.java
	- DaoCompte.java
	- DaoComseiller.java
	- SQLDaoClient.java
	- SQLDaoCompte.java
	- SQLDaoConseiller.java

- com.proxibanque3.model
	- Client.java
	- Conseiller.java
	- Compte.java
	- CompteCourant.java
	- CompteEpargne.java
	
- org.proxybanque.service
	- Service.java


*******************************************************
------
Webapp
------
Utilisation du JSF

- racine
	- accueil.xhtml
	- consultationClient.xhtml
	- listeCleints.xhtml
	- login.xhtml
	- virements.xhtml
- template
	- template.xhtml
	- menu.xhtml
	- style.css
- WEB-INF
	- faces-config.xml
	- web.xml
	-	>>LIB
	-	primefaces-5.1.jar

*******************************************************
---------------
Base de données
---------------
Utilisation de JPA

Xampp -> MySQL

*******************************************************
-------------
Mise en forme
-------------
- Utilisation de CSS et primefaces

- Template pour la structure des pages

- Utilisation de JavaScript pour l'espace client encore en construction.

*******************************************************
-----------
Possibilités
-----------

- Se connecter
- Consulter la liste des clients
- Selectionner un client


*******************************************************
-----------------------
Fonctionnalités à venir
-----------------------

- Supprimer un client, ou le modifier
- Supprimer, modifier un compte
- Consulter les informations clients et leurs comptes
- Faire un virement de compte à compte
- Se déconnecter
- Ecran d'erreur
