
public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new LC();

        liste = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF").ConvertionFichier();

        /*
        Cellule c1 = new Cellule(0,2);
        Cellule c2 = new Cellule(2,0);
        Cellule c3 = new Cellule(0,0);
        Cellule c4 = new Cellule(-2,0);
        Cellule c5 = new Cellule(0,-2);

        liste.ajoutEnTete(c1);
        liste.ajoutEnTete(c2);
        liste.ajoutEnTete(c3);
        liste.ajoutEnTete(c4);
        liste.ajoutEnTete(c5);
        */

        liste.affichageTableau();
    }

}
