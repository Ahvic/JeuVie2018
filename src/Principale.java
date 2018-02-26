import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC liste = new LC();

        lectureFichier fichier = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        liste = fichier.ConvertionFichier();


        System.out.println(liste.toString());
    }

}
