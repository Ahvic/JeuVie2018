import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;

public class Principale {

    private static LC liste = null;

    public static void main(String[] Args){

        lectureFichier lF = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();

        deroulementJeu(liste, g, 10);
    }

    public static void deroulementJeu(LC l, Generation g, final int LimiteGeneration){

        //Sert a modifier la valeur de liste dans la classe anonyme actionPerformed
        liste = l;

        //Erreur de compilation si on met l'actionListener directement lors de la declaration
        Timer t = new Timer(5,null);
        t.addActionListener(new ActionListener() {
            int nbGeneration = 0;
            public void actionPerformed(ActionEvent e) {
                
                liste = g.nextGen(liste);
                //Detection etat stable
                //Ajout de la generation dans genPreced de Generation
                System.out.println(liste.affichageTableau());
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
