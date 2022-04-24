# Projet île interdite : développement jeu

Projet de programmation orientée objet de L2 Informatique de Paris-Saclay réalisé par MESBAH Slimane et GENTY emilie.

Objectif du jeu :

L’Ile renferme 4 artéfacts, chacun reliés à plusieurs clés. L'objectif et de récupérer ces différents trésors archéologique et de partir en hélicoptère en coopérant avec ses coéquipiers. Mais l’île sombre, ses différentes parties disparaissent peu à peu, et l’ensemble finira par disparaître sous les flots.

Avant de concevoir le système, nous avons choisi une architecture MVC, qui est la plus adaptée. Cela signifie Model View Controller. Ce style d'architecture s'accompagne également de nombreux avantages.
Notre adaptation du jeu de Matt Leacock, est organisé de la manière suivantes :
- Présence d'un écran d'accueil permettant de lancer le jeu, d'avoir des informations sur les règles du jeu ainsi que d'afficher un menu help pour accéder aux actions réalisables.
 ![image](https://user-images.githubusercontent.com/90608523/164999363-097f37b4-fc8a-46ff-ba5c-f14bcb3f4fb8.png) 
 ![image](https://user-images.githubusercontent.com/90608523/164999378-0d7f8536-6e07-4af3-8f25-75e1c4c334d6.png) 
<center>  
<img width="501" alt="image" src="https://user-images.githubusercontent.com/90608523/164999399-cc8aa616-97cc-40f7-9d0f-4acb5661098a.png">
</center>
- A chaque tour, un joueur peut réaliser 3 actions successives que nous détaillerons par la suite. Une fois ces actions réalisées, le jeu inonde aléatoirement 3 zones et change le joueur en passant au tour suivant. Un joueur peut également choisir de ne pas réaliser toutes les actions et de passer son tour.

<center>
<img width="542" alt="image" src="https://user-images.githubusercontent.com/90608523/164999441-80530beb-11a1-4758-a74f-d417131f98c5.png">
</center>

- Si tous les joueurs ont récupérés l'ensemble des artéfacts et sont sur la zone de l'héliport, alors le jeu est gagné.
  En revanche, si l'ile est inondée, si l'héliport est inondé, ou qu'un des joueurs est entouré par des zones submergées et est bloqué, alors la partie est perdue.
  Un joueur se trouvant sur une case qui est soudainement submergé est automatiquement déplacé aléatoirement sur une des zones adjacente non submergée. S'il aucune n'est disponible, alors la partie est également perdue.
- L'interface du jeu indique également quel joueur doit jouer, avec le nombre d'actions qui lui reste. On peut également voir tous les artéfacts possédés par l'ensemble des joueurs. Enfin, à chaque tour, on peut voir les clés que les joueurs ont en leur possession.

<center><img width="527" alt="image" src="https://user-images.githubusercontent.com/90608523/164999415-e1153c9b-0b49-4834-a3bf-e12fe769f7db.png"></center>

- L'interface graphique permet d'afficher les cartes du jeu. Ces dernières deviennent bleues lorsqu'elles sont inondées et laisse place à l'eau si elles sont submergées (en disparaissant). Sur ces cases sont placés aléatoirement les 4 artéfacts et les joueurs sont disposés au 4 coins du plateau en début de partie. Chacun des joueurs est légèrement décentré de sa case afin de permettre de tous les voir s'ils se trouvent sur la même case.

Nous allons maintenant détailler les différentes actions réalisables par les joueurs ainsi que nos choix d'implémentation. Chacune de ces actions est déclenchable via une touche du clavier.
Tout d'abord un joueurs peut se déplacer sur une case voisine si elle n'est pas submergée. Il peut également passer son tour comme je l'ai expliquer précédemment.
Afin de ralentir la progression du jeu, il lui est possible de sécher les zones adjacentes ou celle sur laquelle il se trouve, si et seulement si cette zone est inondé mais pas submergée.
Ensuite, un joueur peut chercher une clé. Pour cela, nous avons choisi de mettre en place un choix de niveau de difficulté modifiable dans la classe Controlleur. En effet, le joueur réussi à trouver une clé selon une certaine probabilité modifiable avant le lancement du jeu.
Une fois la clé en sa possession un joueur peut la donner à un autre joueur se trouvant sur la même case que lui. Enfin, avec une clé en sa possession, un joueur peut récupérer un artefact se trouvant sur le plateau de jeu si la clé correspond à l'artéfact qu'il cherche à récupérer.
