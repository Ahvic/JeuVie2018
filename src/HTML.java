import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;

public class HTML {
    /*
    int max;
    HTML (int max){
        this.max = max;
    }
    */
    String WorkingDirectory = System.getProperty("user.dir");
    File f = new File(WorkingDirectory+"\\TypeEvolution.html");

    public String[] getFiles(){
        File folder = new File(WorkingDirectory +"\\LIF");
        File [] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File folder, String name) {
                return name.endsWith(".LIF");
            }
        });
        String [] lif = new String[files.length];
        for (int i = 0 ; i < lif.length-1; i++) {
            lif[i] =  files[i].getAbsolutePath();
        }
        return lif;
    }
    public void setHTML (int max){
        String html =  "<!DOCTYPE html><html lang=\"fr\"><head>\n<meta charset=\"utf-8\">\n<link rel=\"stylesheet\" href=\"style.css\">\n<title>page vide</title></head><body><h3>Pour " + max + " generations voici le type d'evolution de tous les jeux contenus : </h3>";
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(f));
            String [] fileslist = getFiles();
            for (int i = 0; i < fileslist.length -1; i++){
                String[] part = fileslist[i].split("\\\\");
                String filename = part[part.length-1];
                //write the evolution time of each file in the HTML file.
                html = html + "<p>nom fichier : " + filename + " type evolution : </p><br>";
            }
            html = html + "</body></html>";
            br.write(html);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

