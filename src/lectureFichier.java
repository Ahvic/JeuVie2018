import java.io.FileNotFoundException;
import java.io.*;

public class lectureFichier {

    public char[][] ConvertionFichier(File fichier){

        return null;
    }

    public static BufferedReader OuvertureFichier(String nom) {
        BufferedReader br = null;

        try {
            File fichier = new File(nom);
            FileReader fr = new FileReader(fichier);
            br = new BufferedReader((fr));

        }catch(FileNotFoundException e) {
            e.toString();
        }

        return br;
    }

}
