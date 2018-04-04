
public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new lectureFichier("C:\\Users\\Antoi\\Documents\\JeuVie2018\\exemple lif\\ACORN.LIF").ConvertionFichier();
        Generation g = new Generation();

        System.out.println(liste.affichageTableau());

        System.out.println(liste.toString());

        Cellule test = new Cellule(-1,1);

        g.comptageVoisins(liste, test);
    }

}
