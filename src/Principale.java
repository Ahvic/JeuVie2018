
public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new LC();

        liste = new lectureFichier("C:\\Users\\Fixe\\Documents\\GitHub\\JeuVie2018\\exemple lif\\ACORN.LIF").ConvertionFichier();

        System.out.println(liste.affichageTableau());
    }

}
