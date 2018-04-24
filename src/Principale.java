import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;

public class Principale {

    private static LC liste = null;

    public static void main(String[] Args){





        lectureFichier lF = new lectureFichier("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN - Original.LIF");


        //lectureFichier lF = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");

        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();

<<<<<<< HEAD
        deroulementJeu(liste, g, 10);
=======

        System.out.println(liste.affichageTableau());
        /*
        while(true) {
            liste = g.nextGen(liste, g.neighbours(liste), 3);
            System.out.println(liste.toString());
        }
        */
        //System.out.println(liste.affichageTableau());



        //System.out.println(g.Survivre(liste));
        //System.out.println(g.comptageVoisins(liste, c));


        for(int i = 0; i < 10; i++){
            liste = g.nextGen(liste);
            System.out.println(liste.affichageTableau());
            System.out.println(liste);
            System.out.println("~~~~~~~~");
        }


>>>>>>> 1f2e375e8200fc6662d1663925c2d72e08ad22e8
    }

    public static void deroulementJeu(LC l, Generation g, final int LimiteGeneration){

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
