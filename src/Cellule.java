public class Cellule {
    int colonne;
    int ligne;
    int nbVoisin;

    public Cellule(int colonne, int ligne){
        this.colonne = colonne;
        this.ligne = ligne;
        nbVoisin = 0;

    }

    public int getNbVoisin() {
        return nbVoisin;
    }

    public void setNbVoisin(int nbVoisin) {
        this.nbVoisin = nbVoisin;
    }

    /**
     * Determine si la cellule est situe en dehors des limites du plateau
     * La limite a une forme rectangulaire
     * Tolere que la cellule soit sur place sur la limite
     *
     * @param coinHautGauche les coordonnées au format [x,y] du coin haut gauche de la limite
     * @param coinBasDroit les coordonnées au format [x,y] du coin bas droit de la limite
     * @return vrai si la cellule est dans le plateau, faux sinon
     */

    public boolean determineDansLimite(int[] coinHautGauche, int[] coinBasDroit) throws IllegalArgumentException{

        if(coinHautGauche[0] > coinBasDroit[0] || coinHautGauche[1] > coinBasDroit[1])
            throw new IllegalArgumentException("La valeur de coinHautGauche ou coinBasDroit est incoherente");

        return colonne >= coinHautGauche[0] && ligne >= coinHautGauche[1] && colonne <= coinBasDroit[0] && ligne <= coinBasDroit[1];
    }

    public String toString(){
        return "(" + colonne + "," + ligne + ")";
    }
}
