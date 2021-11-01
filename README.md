# Complexity : Mini Projet 1
commandes d'exécution:
Pour exécuter le projet il faut se déplacer  jusqu’à la racine du projet(dossier src) et taper la commande suivante  : javac *.java
Pour exécuter une instance  du projet : 
on fait :
java Main nom_du_mini_Projet la_méthode (nom_du_fichier ou un_entier_n)
Main : c’est la classe principale à compliler
nom_du_mini_Projet : c’est le nom du mini projet à exécuter 
la_méthode : la fonction à exécuter pour chaque mini-projet par exemple ZoneDenseMaximum
 nom_du_fichier ou un_entier_n : le nom du fichier à tester ou l’entier n à tester pour les problèmes de Fibonacci
Exemple:
// java Main Fibonacci FibonrecuacciRecursive n
// java Main MachineTuring run  chemin_vers_le_fichier
// java Main ZoneDense ZoneDenseMaximum chemin_vers_le_fichier

Mini projet 01 : Fibonacci
Pour Fibonacci on a trois méthodes : iterative, recursive, exponentiation (il faut les écrire comme ça dans les commandes pour que ça marche)
Exemple pour exécuter Fibonnacci pour exponentiation avec n =50 : 
java Main Fibonacci exponentiation 50
Exemple pour exécuter Fibonnacci pour recursive avec n =50 : 
java Main Fibonacci recursive 50
Exemple pour exécuter Fibonnacci pour exponentiation avec n =50 : 
java Main Fibonacci exponentiation 50


Mini projet 02 : ZoneDense
Pour Zone Dense on a trois méthodes :  testZoneDense, ZoneDenseMaximal,ZoneDenseMaximum
Exemple :
1) pour lancer la commande de testZoneDense : 
java Main ZoneDense testZoneDense chemin_vers_le_fichier
2)  pour lancer la commande de ZoneDenseMaximal : 
java Main ZoneDense ZoneDenseMaximal chemin_vers_le_fichier
3)  pour lancer la commande de ZoneDenseMaximum : 
java Main ZoneDense ZoneDenseMaximum chemin_vers_le_fichier
Format du fichier :
1er ligne : représente le nombre de sommets du graphe.
2ème ligne : les sommets à tester pour la méthode testZoneDense
Le reste du fichier représente les arêtes  pour un couple de sommets(2 sommets)
Exemple d’un fichier:
#################################################
4
1 2 3
0 2
1 2
0 1
3 1
3 2
3 0
################################################
Et le graphe ci-dessous correspond au code de ce fichier .

 NB : vous pouvez déplacer les sommets dans l’interface graphique pour plus de visibilité.


Mini projet 03 : Machine Turing
Pour Machine de Turing, on a une seule méthode à tester run
La commande à lancer pour tester cette méthode est :
java Main MachineTuring run chemin_vers_le_fichier

Format du fichier machine de Turing 


En ce qui concerne le format du fichier qui contient la machine de Turing à simuler voici la structure du fichier :
Pour la première ligne il suffit de donner les états de la machine séparés par des vides puis à la fin de nos états il suffit de rajouter l’état initial puis l’état final séparer par un vide.
Pour la deuxième ligne, elle va contenir le mot de l’entrée de la machine de Turing à simuler.
Pour la troisième ligne c’est réserver au symbole avec le quel on représente le Blanc .
Et pour la suite des lignes ça dépendra du nombre de transition que va contenir la machine de Turing à simuler .
Pour chaque transition il suffit de la noter de la forme suivante :
« état »vide« symbole_lu »vide« état_suivant »vide« symbole_écrit » « direction (1 : right, -1 : left) »
et avant de lancer le code veuillez vérifiez que vous n’avez pas mis de ligne vide en plus a la fin du fichier
voici le format du fichier :

voici un exemple testé:
la machine du turing (Exo1-TD3) et son fichier .txt correspondant:
(sans l’état Qnon et les transitions vers Qnon)
q0 = 0, q1 = 1, q2 = 2, qf = 3




