public class Cellule {
    int colonne;
    int ligne;

    public Cellule(int colonne, int ligne){
        this.colonne = colonne;
        this.ligne = ligne;

    }

    public String toString(){
        return "(" + colonne + "," + ligne + ")";
    }
}
