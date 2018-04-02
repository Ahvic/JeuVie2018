import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new LC();

        liste = new lectureFichier("C:\\Users\\Antoi\\OneDrive\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF").ConvertionFichier();

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

        //System.out.println(liste.toStringTab());
        System.out.println(liste.affichageTableau());

        /*
        String m = "c";

        m = "b" + "\n" + m;

        System.out.println(m);
        */
    }

}
