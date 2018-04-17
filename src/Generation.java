import java.lang.Math;
import java.util.Arrays;

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

    public int comptageVoisins(LC l, Cellule c){
        int res = 0;

        Maillon m = l.tete;
        Cellule info = (Cellule)m.info;

        while(m!= null){
            if(m.info instanceof Cellule) {
                if(c.colonne - info.colonne == 0){
                    if((Math.abs(c.ligne - info.ligne)) == 1) {
                        res++;
                    }
                }
                else{
                    if(Math.abs(c.colonne - info.colonne) == 1){

                        int dY = Math.abs(c.ligne - info.ligne);

                        if(dY == 1 || dY == 0){
                            res++;
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

    public int comptageVoisins(LC l, LC n, Cellule c){
        int res = 0;

        Maillon m = l.tete;
        Cellule info = (Cellule)m.info;

        while(m!= null){
                if(m.info instanceof Cellule) {
                    if(c.colonne - info.colonne == 0 && !n.appartientListe((Cellule)m.info)){
                        if((Math.abs(c.ligne - info.ligne)) == 1) {
                            res++;
                            //System.out.println(info.toString());
                        }
                    }
                    else{
                        if(Math.abs(c.colonne - info.colonne) == 1 && !n.appartientListe((Cellule)m.info)){

                            int dY = Math.abs(c.ligne - info.ligne);

                            if(dY == 1 || dY == 0){
                                res++;
                                //System.out.println(info.toString());
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
        Maillon m = l.tete;
        LC res = l.copie();

        while (m != null) {
            int nbVoisin = comptageVoisins(l,((Cellule) m.info));
            boolean suppression = true;

            for(int i = 0; i < regleSurvie.length; i++){

                if (nbVoisin == regleSurvie[i])
                    suppression = false;


                if(suppression) {
                    res.supprimer1oc((Cellule) m.info);
                    break;
                }
            }

            m = m.suivant;
        }

        return res;
    }

    public  LC neighbours (LC l){
        LC<Cellule> n = new LC<>();
        Maillon m = l.tete;
        while (m != null){
            Cellule cell = (Cellule)m.info;
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                    if (i == 0 && j == 0) continue;

                    if(!l.appartientListe(neighbour) && !n.appartientListe(neighbour)){
                        n.ajout(neighbour);
                        //System.out.println(neighbour);
                    }
                }
            }
            m = m.suivant;
        }
        return n;
    }

    //L'argument x est deja dans la classe avec RegleNaissance
    //Naissance avant survit
    //Pas encore teste
    public LC nextGen (LC l, LC n, int x){

        Maillon m = n.tete;

        //Rajoute les cellules qui doivent naitrent
        LC<Cellule> nouvCell = new LC<>();

        while(m!= null){
            Cellule cell = (Cellule)m.info;
            //System.out.println("cellule : " + cell + "voisins : ");
            if (comptageVoisins(l, n, cell) == x){
                nouvCell.ajout(cell);
            }
            m = m.suivant;
        }

        l = Survivre(l);
        l.fusion(nouvCell);

        return l;
    }

    public String detectionEvolution(LC l){
        String res = "Pas d'evolution particuliere";

        if(l.estListeVide()) return "Mort";

        if(!genPreced.estListeVide()) {
            if (l.equal(genPreced.tete.info)) return "Stable";
        }

        return res;
    }
}
