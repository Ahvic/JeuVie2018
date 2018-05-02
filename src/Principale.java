import java.awt.*;
import java.io.*;
import javax.swing.Timer;
import java.awt.event.*;

public class Principale {


    public static void main(String[] Args){

        //passer le dossier en parametre
        //System.out.println("Working directory : " + System.getProperty("user.dir"));

        String WorkingDirectory = System.getProperty("user.dir");
        if (Args[0].contains("-w")){
            HTML h = new HTML();
            File htmlFile = new File(WorkingDirectory +"\\TypeEvolution.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (Args[0].contains("-name")){
                System.out.println("ROBLOU Antoine");
                System.out.println("OLINGA-MEDJO Loic");
                System.out.println("ZHANG Ling");
            }
            else{
                if (Args[0].contains("-h")){
                    System.out.println("Tapez '-name' apres 'java -JeuDeLaVie.jar' pour afficher les noms et prenoms des etudiants du groupe");
                    System.out.println("Tapez '-h' apres 'java -JeuDeLaVie.jar' pour afficher les options du programme");
                    System.out.println("Tapez '-s d 'nom du fichier'.lif apres 'java -JeuDeLaVie.jar' pour executer une simulation du jeu d'une duree d (celui que vous avez passe en parametre) affichant les configurations du jeu avec le numero de la generation");
                    System.out.println("Tapez '-c max 'nom du fichier'.lif apres 'java -JeuDeLaVie.jar' pour visualiser le type d'evolution du jeu avec ses caracteristiques (taille de la queue, periode et deplacement), max represente la duree maximale de simulation pour deduire les resultats du calcul");
                    System.out.println("Tapez '-w max dossier' apres 'java -JeuDeLaVie.jar' pour voir le type d'evolution de tous les jeux contenus dans le dossier passe en parametre et voir les resultats dans un fichier html");
                }
                else {
                    if (Args[0].contains("-s")){
                        System.out.println(Args[1] + Args [2] + "sq");
                        System.out.println(WorkingDirectory +"\\LIF\\"+ Args[2]);
                        int d = Integer.parseInt(Args[1]);
                        //simulation jeu de la vie
                        lectureFichier LIF = new lectureFichier(WorkingDirectory +"\\LIF\\"+ Args[2]);
                        Generation g = new Generation(LIF.ExtractionRegle());
                        LC<Cellule> liste = LIF.ConvertionFichier();
                        Principale p = new Principale();
                        p.deroulementJeu(liste, g, d);
                    }
                    else {
                        if (Args[0].contains("-w")){
                            //calcule type d'evolution d'un jeu
                        }
                        else {
                            System.out.println("Veuillez retapez l'option correctement");
                        }
                    }
                }
            }

        }
    }




        lectureFichier lF = new lectureFichier("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN - Original.LIF");
    private static LC liste = null;
    /*
    public static void main(String[] Args){

        lectureFichier lF = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF");
        Generation g = new Generation(lF.ExtractionRegle());

        LC<Cellule> liste = lF.ConvertionFichier();


        /*
        while(true) {
            liste = g.nextGen(liste, g.neighbours(liste), 3);
            System.out.println(liste.toString());
        }
        */
        //System.out.println(liste.affichageTableau());



        //System.out.println(g.Survivre(liste));
        //System.out.println(g.comptageVoisins(liste, c));
        /*

        for(int i = 0; i < 10; i++){
            liste = g.nextGen(liste);
            System.out.println(liste.affichageTableau());
            System.out.println(liste);
            System.out.println("~~~~~~~~");
        }





        deroulementJeu(liste, g, 10);

    */

    public static void deroulementJeu(LC l, Generation g, final int LimiteGeneration){

        //Sert a modifier la valeur de liste dans la classe anonyme actionPerformed
        liste = l;

        //Erreur de compilation si on met l'actionListener directement lors de la declaration
        Timer t = new Timer(1,null);
        t.addActionListener(new ActionListener() {
            int nbGeneration = 0;
            public void actionPerformed(ActionEvent e) {
                
                liste = g.nextGen(liste);
                //Detection etat stable
                //Ajout de la generation dans genPreced de Generation
                System.out.println(l.affichageTableau());

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

