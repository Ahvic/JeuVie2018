import java.util.Scanner ;

class JeuDeLaVie {

	static Scanner in = new Scanner(System.in);

	static void afficherPlateau(int[][] tableau, int generation) { /* Affiche le plateau du jeu, avec "." repr?sentant une cellule morte et "#" une cellule vivante */
		System.out.println(generation);                          /*  et la generation*/
		for (int i = 0; i < tableau.length; i++) {
			System.out.println("");
			for (int j = 0; j < tableau[0].length; j++) {
				if (tableau[i][j] == 1) {
					System.out.print("#");
				} else {
					System.out.print(".");
				}
			}
		}
	}

	static int voisinVivantOuMort(int[][] cellule, int a, int b) {        /* Verifie si une cellule est morte ou vivante, avec 1:en vie et 0:mort  */
		if (cellule[a][b] == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	static int statutVoisin(int[][] voisin, int a, int b) {
		int nbvoisinvivant;
		nbvoisinvivant = 0;
		if (a != voisin.length - 1) {
			nbvoisinvivant = voisinVivantOuMort(voisin, a + 1, b);                           /* Verifie si la cellule ? droite est vivante ou pas */
		}
		if (a != 0) {
			nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a - 1, b);            /* Verifie si la cellule ? gauche est vivante ou pas */
		}
		if (b != voisin[0].length - 1) {
			nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a, b + 1);            /* Verifie si la cellule en bas est vivante ou pas */
		}
		if (b != 0) {
			nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a, b - 1);            /* Verifie si la cellule en haut est vivante ou pas */
		}
		if (a != voisin.length - 1) {
			if (b != voisin[0].length) {
				nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a + 1, b + 1);          /* Verifie si la cellule en bas a droite est vivante ou pas*/
			}
			if (b != 0) {
				nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a + 1, b - 1);          /* Verifie si la cellule en haut a droite est vivante ou pas */
			}
		}
		if (a != 0) {
			if (b != voisin[0].length - 1) {
				nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a - 1, b + 1);          /* Verifie si la cellule en bas ? gauche est vivante ou pas */
			}
			if (b != 0) {
				nbvoisinvivant = nbvoisinvivant + voisinVivantOuMort(voisin, a - 1, b - 1);          /* Verifie si la cellule en haut ? gauche est vivante ou pas */
			}
		}

		return nbvoisinvivant;                                                       /* retourne le nombre de voisins en vivant */
	}


	static int mortOuVivant(int nombrevoisinvivant, int[][] tab2, int c, int d) {               /*Si une cellule vivante et est entour?e de 2 ou 3 cellules vivante alors elle  */
		if (tab2[c][d] == 1) {                                                         /* reste en vie, sinon elle meurt.  */
			if (nombrevoisinvivant != 2 || nombrevoisinvivant != 3) {                   /* Si une cellule est morte et est entour?e de exactement 3 cellules vivante  */
				tab2[c][d] = 0;                                                       /* alors elle devient vivante.  */
			}
		} else {
			if (nombrevoisinvivant == 3) {
				tab2[c][d] = 1;
			}
		}
		return tab2[c][d];
	}
}
/*
    public static void main ( String [] args) {

	int generation, longueur, largeur, nbinitialisation, colonne, ligne,nbvoisinenvie,pause;
	int [][] plateau;
	generation=0;
	System.out.println("Choissisez la dimension du plateau, en entrant la longeur puis la largeur");
	longueur=in.nextInt();
	largeur=in.nextInt();
	plateau=new int[longueur][largeur];
	afficherPlateau(plateau,generation);
	generation=1;
	System.out.println("");
	System.out.println("Choisissez le nombre de cellules vivante que vous voulez placer");
	nbinitialisation=in.nextInt();
	while (nbinitialisation!=0){
	    System.out.println("entrez la colonne de la cellule, puis la ligne");
	    colonne=in.nextInt();
	    while (colonne > longueur){
		System.out.println("entrez une colonne dans les dimension du tableau");
		colonne=in.nextInt();
	    }
	    ligne=in.nextInt();
	    while (ligne > largeur){
		System.out.println("entrez une ligne dans les dimension du tableau");
		ligne=in.nextInt();
	    }
	    plateau[colonne][ligne]=1;
	    nbinitialisation=nbinitialisation-1;
       }
	afficherPlateau(plateau,generation);
	while(generation>0){           //Programme qui ne s'arr?tera pas
	    for(int y=0;y<plateau.length; y++){
		for (int z=0; z<plateau[0].length; z++){
		    nbvoisinenvie=statutVoisin(plateau,y,z);
		    plateau[y][z]=mortOuVivant(nbvoisinenvie,plateau,y,z);
		}
	    }
		    afficherPlateau(plateau,generation);
		    generation=generation+1;
		    pause=in.nextInt();
	}
    }
}
  */
