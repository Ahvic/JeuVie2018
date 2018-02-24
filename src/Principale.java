import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC liste = new LC();

        lectureFichier fichier = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        //liste = fichier.ConvertionFichier();



        int[] n1 = {1,1};
        int[] n2 = {1,2};
        int[] n3 = {1,3};

        liste.ajout(n1);
        liste.ajout(n2);
        liste.ajout(n3);
        liste.ajout(n1);
        liste.ajout(n2);
        liste.ajout(n1);


        System.out.println(liste.toString());
    }

}
