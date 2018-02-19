import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC liste = new LC();

        List<int[]> runtest = new ArrayList<>();

        int[] coord1 = {3,1};
        int[] coord2 = {1,2};
        int[] coord3 = {1,3};
        int[] coord4 = {1,1};
        int[] coord5 = {1,5};
        int[] coord6 = {2,1};
        int[] coord7 = {0,0};


        liste.ajout(coord1);
        System.out.println(liste.toString());

        liste.ajout(coord2);
        System.out.println(liste.toString());

        liste.ajout(coord3);
        System.out.println(liste.toString());

        liste.ajout(coord4);
        System.out.println(liste.toString());

        liste.ajout(coord5);
        System.out.println(liste.toString());

        liste.ajout(coord6);
        System.out.println(liste.toString());

        //liste.ajout(coord7);
        //System.out.println(liste.toString());

        //Probleme avec le cas de 0,0
    }

}
