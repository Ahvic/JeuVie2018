import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;

public class Principale {

    public static void main(String[] Args){

        lectureFichier lF = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();

        //System.out.println(liste.affichageTableau());

        Cellule c = new Cellule(0,0);

        //System.out.println(g.Survivre(liste));
        //System.out.println(g.comptageVoisins(liste, c));

    }

    public static void deroulementJeu(LC l, final int LimiteGeneration){

        //Erreur de compilation si on met l'actionListener directement lors de la declaration
        Timer t = new Timer(5,null);
        t.addActionListener(new ActionListener() {
            int nbGeneration = 0;
            public void actionPerformed(ActionEvent e) {

                System.out.println(nbGeneration);

                //Calcul generation suivante
                //Detection etat stable
                //Ajout de la generation dans genPreced de Generation
                //System.out.println(l.affichageTableau());
                nbGeneration++;

                if(nbGeneration == LimiteGeneration) {
                    System.out.println("Appuyez sur entree pour continuer");
                    t.stop();
                }
            }
        });
        t.start();

        try {
            System.in.read();
        }
        catch (IOException e){}

        t.stop();
    }
}
