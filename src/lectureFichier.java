import java.io.FileNotFoundException;
import java.io.*;

public class lectureFichier {

    private BufferedReader br;

    public lectureFichier(String nom){
        try {
            File fichier = new File(nom);
            FileReader fr = new FileReader(fichier);
            br = new BufferedReader(fr);

            try{
                br.mark(20000);
            }catch(IOException e){

            }

        }catch(FileNotFoundException e) {
            System.out.println("Le fichier indique n'existe pas");
        }
    }

    public LC<Cellule> ConvertionFichier(){
        LC<Cellule> res = new LC();
        int offsetX = 0;
        int offsetY = 0;

        try{
            br.reset();
        }catch(IOException e){
            System.out.println(e.toString());
        }

        try {
            for (String line = br.readLine(); line != null; line = br.readLine()) {

                if(!line.equals("")) {
                    if (line.charAt(0) == '#') {
                        String[] decoupe = line.split(" ");

                        if (decoupe[0].equals("#P")) {
                            offsetX = Integer.parseInt(decoupe[1]);
                            offsetY = Integer.parseInt(decoupe[2]);
                        }
                    } else {
                        for (int i = 0; i < line.length(); i++) {
                            if (line.charAt(i) == '*') {
                                res.ajoutEnTete(new Cellule(i + offsetX, offsetY));
                            }
                        }
                        offsetY++;
                    }
                }
            }
        }catch (IOException e){
            e.toString();
        }

        return res;
    }

    /**
     * Format de la règle : [survie]/[naissance]
     * 23 se lis 2 ou 3
     *
     * @return la regle au format string
     */

    public String ExtractionRegle(){
        String res = "23/3";

        try{
            br.reset();
        }catch(IOException e){
            System.out.println(e.toString());
        }

        try{
            for(String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
                if(ligne.startsWith("#N"))
                    break;

                if(ligne.startsWith("#R")){
                    res = ligne.substring(3);
                    break;
                }
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }

        return res;
    }
}