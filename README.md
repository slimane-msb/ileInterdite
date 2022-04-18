# ileInterdite

# problem
## model : 
1. model: island & players: add player to island: on a choisi la zone[0][0] comme zone helicop ou on a mis tous les joueur lors de leur creation
 




## view :
1. view:island & zone: submerge the borders (last one is not submerged ) dans la vue: en passant l'index de la zone en parametre pour le constructeur, et en applant la methode convert state to color, on a pu colorier automatiqueent les zones lors de la creation du l'island dans le controlleur
2. JFrame.EXIT_ON_CLOSE : 
   1. problem: ca ferme pas la fenetre quand on clique sur EXIT apres avoir cliqué sur endOFround pleusieur fois : 
   2. solution: 



## controller :
2 controller: player round management: pour automatiser la touche endOfRound, on a enlevé ce button, et il sera cliqué automatiquement des qu'un jour effictue son dernier (3em) tour.