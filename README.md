mongodb-redis
=============

Travaux pratiques Master 1 miage. Istic, Université de Rennes 1.
Ce tp nous initie aux bases nosql telles que MongoDB (base de données 
orientée document) et Redis (base de données clé-valeur).
=============

1 - LIMITES DES BASES ORIENTEES DOCUMENT.

* Elles sont limitées au niveau des transactions. Pour la modification de plusieurs
objets dépendant les uns des autres, les bases orientées document n'offrent pas les 
garanties qu'on retrouve avec le relationnel.

* Les propriétés ACID ainsi que les contraintes d'intégrité ne sont généralement pas
implémentées. Ainsi, c'est la partie applicative qui gère ces propriétés.

* Les bases de données orientées document ne dispose pas d'un langage de requête aussi
puissant que celui des bases relationnels. Ce qui empêche ces bases de données document
de générer des rapports complexes, domaine dans lequel les bases relationnelles sont très à l'aise.
=============

2 - REDIS. Base de données clé-valeur.

* Types de données stockés dans Redis et types de requêtes.
  - Chaîne de caractères
  - listes
  - tableaux associatifs
  - ensembles triés d'éléments
  
  Et Redis dispose pour chacun de ces types des opérations avancées.
  
* Types de requêtes.
  - 
  
