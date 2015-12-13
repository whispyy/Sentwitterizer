# Rapport PJE
# Twitter Sentiment Analyzer
Julien Leclercq & Jean-Frédéric Durand


----
## Présentation du projet

### I / Problématique

#### Objectif
L'objectif de ce PJE est de manière globale d'analyser l'attitude d'un tweet, en fonction de son contenu. Étant dans la région Nord, Pas-de-calais et proche de la Belgique, nous avons estimé que culturellement parlant faire une analyse autours du sujet qu'est la bière et les frites nous permettrait de révéler l'attitude d'une majorité de tweets "locaux".

#### Notion de classification
Lors de ce PJE la classification s'est faite selon la norme suivante. Lors de la récupération des tweets on index un nombre à -1.
Une fois annoté il se verra affecté un nombre : 0, 1, 2 si le tweet est respectivement négatif, neutre ou positif.
Par la suite ce classement nous permettra de catégoriser les tweets à visée positive, négative ou neutre.

#### Marge d'erreur
La classification automatique n'est cependant pas parfaite. En effet il est très difficile de classifier certains tweets tel que les tweets à connotation sarcastique par exemple. Ou encore l'ironie étant donné que ces types de tweets sont sémantiquement très proche des tweets ayant une visée au premier degré.

### II / Architecture de l'application

#### Paquetage
Le projet réalisé à été développé en Ruby on rails avec les paquets suivant :

 - Base de donnée : SQLITE3
 - HTML : Slim
 - CSS : Bootstrap
 - API : Twitter (for ruby on rails)

#### Modèle de conception
Pour ce projet nous avons opté pour un modèle MVC natif et représentatif de l'environnement Ruby.


A REMPLIR

----
## Détails des travaux effectués

### I / API Twitter
Premièrement, on a configuré le client de l'API twitter dans un controller d'initialisation : 
app/controllers/concerns application_concern.rb.

Deuxièmement, à l'aide du tweet_search_controller.rb nous effectuons une requête d'envoi de recherche de tweet via un paramètre de recherche. Ce paramètre de recherche peut être un mot clé ou un pseudo.

### II / Base d'apprentissage

#### Nettoyage des données
Le nettoyage des tweets s'effectue dans le repertoire : app/models/tweets.rb.
On y retrouve les principales fonctions qui sont :

 - remove_url : Supprime un lien url fournit dans un tweet
 - remove_rt : a faire
 - remove_quotes : a faire
 - remove_arobase : a faire
 - remove_hashtag : a faire

#### Construction de la base
La construction de la base est visible depuis le répertoire db/migrate du projet.
Nous y définissons la création de la table de stockage d'un tweet selon les critères suivants :

 - tweet_id : l'identifiant twitter du tweet
 - twittos : la personne qui a publié le tweet
 - text : le corps du tweet
 - annotation : l'entier défini pour la classification
 - created_at : date de création dans la base
 - updated_at : date de mise a jour dans la base

A noter que nous avons du augmenter la taille des entier par défaut de sqlite3 à 20.En effet le tweet_id à actuellement une longueur de 18 caractères.

De plus nous avons défini les les données de dates (created_at,updated_at) comme facultatives.

### III / Algorithmes de classifications

#### mots-clés

#### KNN

#### Bayes

### IV / Interface graphique

mettre des copies d'écrans et décrire l'utilisation