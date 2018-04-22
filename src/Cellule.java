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

    public String toString(){
        return "(" + colonne + "," + ligne + "):" + nbVoisin + " ";
    }
}
