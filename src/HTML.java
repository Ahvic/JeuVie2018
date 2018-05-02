import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;
public class HTML {

    String html = "<!DOCTYPE html><html lang=\"fr\"><head>\n<meta charset=\"utf-8\">\n<link rel=\"stylesheet\" href=\"style.css\">\n<title>page vide</title></head><body>" ;
    File f = new File("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\src\\Raw.html");

    public String[] getFiles(){
        File folder = new File("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif");
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
    {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(f));
            String [] fileslist = getFiles();
            for (int i = 0; i < fileslist.length -1; i++){
                String[] part = fileslist[i].split("\\\\");
                String filename = part[7];
                System.out.println(part[7]);
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
