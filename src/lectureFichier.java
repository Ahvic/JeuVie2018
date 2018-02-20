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

    public LC ExtractionCellule(){
        String info = ConvertionFichier();
        LC res = new LC();

        int nbLigne = 0;

        for(int i = 0; i < info.length(); i++)
            if(info.charAt(i) == '\n')
                nbLigne++;

        System.out.println(nbLigne);

        return res;
    }

    public String ConvertionFichier(){
        String res = "";

        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                res += line;
            }
        }catch (IOException e){
            System.out.println(e);
        }

        return res;
    }

    /**
     * Format de la règle : [survie]/[naissance]
     * 23 se lis 2 ou 3
     *
     * @param br le fichier lif passé par OuverturFichier()
     * @return la regle au format string
     */

    public String ExtractionRegle(){
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