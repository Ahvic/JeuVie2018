import java.io.FileNotFoundException;
import java.io.*;

public class lectureFichier {

    private static BufferedReader br = null;

    public lectureFichier(String nom){
        try {
            File fichier = new File(nom);
            FileReader fr = new FileReader(fichier);
            br = new BufferedReader((fr));

        }catch(FileNotFoundException e) {
            e.toString();
        }
    }

    public char[][] ConvertionFichier(){
        char[][] res = null;

        //Doit etre une liste chainée

        return res;
    }

    /**
     * Format de la règle : [survie]/[naissance]
     * 23 se lis 2 ou 3
     *
     * @param br le fichier lif passé par OuverturFichier()
     * @return la regle au format string
     */

    public static String ExtractionRegle(){
        String res = "23/3";

        //Deconne si on a une ligne avec un espace

        try{
            for(String ligne = br.readLine(); ligne != null; ligne = br.readLine()){
                if(ligne.charAt(1) == 'R')
                    res = ligne.substring(3);
            }
        }catch(IOException e){
            e.toString();
        }

        return res;
    }
}