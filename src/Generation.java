
import java.lang.Math;

public class Generation {

    private String regle;
    private int[] regleSurvie;
    private int[] regleNaissance;
    LC<LC<Cellule>> genPreced = new LC<>();

    public Generation(String valeur){
        regle = valeur;

        //Extraction des regles de valeur
        String[] mem = regle.split("/");

        int[] regleSurvie = new int[mem[0].length()];
        for(int i = 0; i < mem[0].length(); i++) {
            int res = mem[0].charAt(i);

            if(res < 48 || res > 57) throw new IllegalArgumentException();
            else
                regleSurvie[i] = res - 48;
        }
        this.regleSurvie = regleSurvie;

        int[] regleNaissance = new int[mem[1].length()];
        for(int i = 0; i < mem[1].length(); i++)
            regleNaissance[i] = Character.getNumericValue(mem[1].charAt(i));
        this.regleNaissance = regleNaissance;
    }

    public String getRegle(){
        return regle;
    }

    public LC getGenPreced(){
        return genPreced;
    }

    public void ajoutGenPreced(LC l){
        genPreced.ajoutEnTete(l);
    }

    public LC generationSuivante(LC l){
        l = Survivre(l);
        //l = birth(l);
        genPreced.ajoutEnTete(l);
        return l;
    }

    //Fonctionne

    public int comptageVoisins(LC l, Cellule c){
        int res = 0;

        Maillon m = l.tete;
        Cellule info = (Cellule)m.info;

        while(m!= null){
                if(m.info instanceof Cellule) {
                    if(c.colonne - info.colonne == 0){
                        if((Math.abs(c.ligne - info.ligne)) == 1) {
                            res++;
                            //System.out.print(info.toString());
                        }
                    }
                    else{
                        if(Math.abs(c.colonne - info.colonne) == 1){

                            int dY = Math.abs(c.ligne - info.ligne);

                            if(dY == 1 || dY == 0){
                                res++;
                                //System.out.print(info.toString());
                            }
                        }
                    }
                }
                m = m.suivant;

                if(m != null)
                    info = (Cellule)m.info;
        }

        return res;
    }


    public LC Survivre(LC l) {
        int[] x = {};
        Maillon m = l.tete;

        while (m != null) {
            for(int i = 0; i < x.length; i++){
                boolean suppression = false;

                if (comptageVoisins(l, ((Cellule) m.info)) == x[i]) {
                    suppression = true;
                }

                if(suppression)
                        l.supprimer1oc((Cellule) m.info);
            }

            m = m.suivant;
        }

        return l;
    }

    public LC birth (LC l, int x){
        LC<Cellule> done = new LC<Cellule>();
        Maillon m = l.tete;
        int a = 0;

        int b = 0;
        while (m != null){
            Cellule cell = (Cellule)m.info;
            //System.out.println(cell.toString());
            //System.out.println("nombre de voisins : " + comptageVoisins(l, cell));
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                    //System.out.println("cellule : " + neighbour.toString());
                    //System.out.println("voisins : " + comptageVoisins(l, neighbour));

                    System.out.println(cell + " " + neighbour + " " + l.appartientListe(neighbour));

                    if (l.appartientListe(neighbour)) b++;

                    /*if (i == 0 && j == 0) continue;
=======
        while (m != null){
            Cellule cell = (Cellule)m.info;
            System.out.println(cell.toString());
            System.out.println(comptageVoisins(l, cell));
            for(int i = -1; i < 1; i++){
                for(int j = -1; j < 1; j++){
                    Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                    //System.out.println(neighbour.toString());
                    //System.out.println(comptageVoisins(l, neighbour));
                    if (i == 0 && j == 0) continue;

>>>>>>> 0a3f41ac3f90af7418a21d60c84cd6a1f7bd3c6e
                    if(!l.appartientListe(neighbour) && !done.appartientListe(neighbour)){
                        if (comptageVoisins(l, neighbour) == x) {
                            done.ajoutEnTete(neighbour);
                            l.ajoutEnTete(neighbour);
                            a ++;
                        }

                    } */

                    }




                }
            }
            m = m.suivant;
        return l;
        }




    public String detectionEvolution(LC l){
        String res = "Pas d'evolution particulere";

        if(l.estListeVide()) return "Mort";

        if(!genPreced.estListeVide()) {
            if (l.equal(genPreced.tete.info)) return "Stable";
        }

        return res;
    }
}
