<<<<<<< HEAD
=======
import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;
>>>>>>> 0a3f41ac3f90af7418a21d60c84cd6a1f7bd3c6e

public class Principale {

    public static void main(String[] Args){

<<<<<<< HEAD
        LC<Cellule> liste = new LC();
        Generation generation = new Generation();
        liste = new lectureFichier("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif\\PI.LIF").ConvertionFichier();

        System.out.println(liste.toString());
        //System.out.println(generation.birth(liste, 2));

        Cellule test = new Cellule(5,4);

        liste.ajout(test);

        System.out.println(liste.appartientListe(test));
       /* Maillon m = liste.tete;

        while(m != null){
            System.out.print((Cellule)m.info);
            m = m.suivant;
        }
        */
    }
=======
        lectureFichier lF = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();

        Cellule c1 = new Cellule(2,5);

        //liste.ajout(c1);

        System.out.println(liste.appartientListe(c1));
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
>>>>>>> 0a3f41ac3f90af7418a21d60c84cd6a1f7bd3c6e

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
