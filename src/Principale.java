import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new LC();

        liste = new lectureFichier("C:\\Users\\Antoi\\OneDrive\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF").ConvertionFichier();

        System.out.println(liste.toString());

        Cellule survivante = new Cellule(3,1);
        Cellule omae = new Cellule(2,1);

        Generation gen = new Generation();

        System.out.println(gen.comptageVoisins(liste, omae));
    }

}
