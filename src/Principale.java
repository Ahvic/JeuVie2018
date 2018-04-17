import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;

public class Principale {

    public static void main(String[] Args){

        lectureFichier lF = new lectureFichier("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif\\PI.LIF");
        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();

        Cellule c1 = new Cellule(2,2);


        //liste.ajout(c1);


        System.out.println(liste.affichageTableau());
        /*
        Maillon m = g.nextGen(liste, g.neighbours(liste), 2).tete;
        while (m != null){
            System.out.println("cellule : " + (Cellule)m.info + "voisins :");
            //g.comptageVoisins(liste, (Cellule)m.info);
            if (g.comptageVoisins(liste, (Cellule)m.info) == 2){
                System.out.println(g.comptageVoisins(liste, (Cellule)m.info));
            }
            m = m.suivant;
        }
        */
        System.out.println(g.nextGen(liste, g.neighbours(liste), 2).affichageTableau());

    }
    /*
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
    */
}
