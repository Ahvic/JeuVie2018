import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC liste = new LC();

        lectureFichier fichier = new lectureFichier("allo ?");
        liste = fichier.ConvertionFichier();

        System.out.println(liste.toStringTab());
    }

}
