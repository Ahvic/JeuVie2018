public class Principale {

    public static void main(String[] Args){

        listeSimplChainee liste = new listeSimplChainee();

        int[] coord1 = {1,1};
        int[] coord2 = {2,1};

        liste.ajout(coord1);
        liste.ajout(coord2);

        System.out.println(liste.toString());


        //Maillon<int[]> m = new Maillon<>(coord1,null);

        //System.out.println(m.toString());

    }

}
