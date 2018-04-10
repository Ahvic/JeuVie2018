
public class Principale {

    public static void main(String[] Args){

        LC<Cellule> liste = new LC();
        Generation generation = new Generation();
        liste = new lectureFichier("C:\\Users\\Loic\\Documents\\GitHub\\JeuVie2018\\exemple lif\\PI.LIF").ConvertionFichier();

        System.out.println(liste.affichageTableau());
        System.out.println(generation.birth(liste, 2));

       /* Maillon m = liste.tete;

        while(m != null){
            System.out.print((Cellule)m.info);
            m = m.suivant;
        }
        */
    }

}
