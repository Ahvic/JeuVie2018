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

    public void ajoutGenPreced(LC l){
        genPreced.ajoutEnTete(l);
    }

    /**
     * Compte le nombre de cellule vivante autours de la cellule c
     * Compte aussi les cellules en diagonales
     *
     * @param l la liste chainee
     * @param c la cellule a traite
     * @return le nombre de voisin
     */

    public void comptageVoisins(LC l, Cellule c){
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

        c.setNbVoisin(res);
    }

    /**
     * Renvoi l'ensemble des cellules et de leurs voisins
     *
     * @param l la liste a analyser
     * @return l'ensemble des cellules existantes et de leurs voisins
     */

    public LC neighbours (LC l){
        LC<Cellule> n = new LC<>();
        Maillon m = l.tete;

        while (m != null){
            Cellule cell = (Cellule)m.info;

            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                    comptageVoisins(l, neighbour);

                    if (i == 0 && j == 0) continue;

                    if(n.estListeVide() || !n.appartientListe(neighbour))
                        n.ajout(neighbour);
                }
            }
            m = m.suivant;
        }
        return n;
    }

    /**
     * Calcul la liste chainee correspondant a la generation suivante
     *
     * @param l la liste chainee de la generation actuelle
     * @return la liste chainee correspondant a la generation suivante
     */

    public LC nextGen (LC l){
        LC<Cellule> res = new LC();
        LC<Cellule> lEtVoisin = neighbours(l);
        Maillon m = lEtVoisin.tete;

        while(m!= null){
            Cellule info = (Cellule)m.info;
            int nbVoisin = info.getNbVoisin();

            if(nbVoisin == 2 && l.appartientListe(info))
                res.ajout(info);

            if(nbVoisin == 3)
                res.ajout(info);

            m = m.suivant;
        }

        return res;
    }

    /**
     * Variante pour un monde avec limite
     * Compte le nombre de cellule vivante autours de la cellule c
     * Compte aussi les cellules en diagonales
     *
     * @param CHG les coordonnées au format [x,y] du coin haut gauche de la limite
     * @param CBD les coordonnées au format [x,y] du coin bas droit de la limite
     * @param l la liste chainee
     * @param c la cellule a traite
     * @return le nombre de voisin
     */

    public void comptageVoisins(LC l, Cellule c, int[] CHG, int[] CBD){
        int res = 0;

        Maillon m = l.tete;
        Cellule info = (Cellule)m.info;

        while(m!= null){
            if(m.info instanceof Cellule) {
                if(info.determineDansLimite(CHG,CBD)) {
                    if (c.colonne - info.colonne == 0) {
                        if ((Math.abs(c.ligne - info.ligne)) == 1) {
                            res++;
                        }
                    } else {
                        if (Math.abs(c.colonne - info.colonne) == 1) {

                            int dY = Math.abs(c.ligne - info.ligne);

                            if (dY == 1 || dY == 0) {
                                res++;
                            }
                        }
                    }
                }
            }
            m = m.suivant;

            if(m != null)
                info = (Cellule)m.info;
        }

        c.setNbVoisin(res);
    }

    /**
     * Variante pour un monde avec limite
     * Renvoi l'ensemble des cellules et de leurs voisins dans une liste chainee avec leurs nombres de voisins mis a jour
     *
     * @param CHG les coordonnées au format [x,y] du coin haut gauche de la limite
     * @param CBD les coordonnées au format [x,y] du coin bas droit de la limite
     * @param l la liste a analyser
     * @return l'ensemble des cellules existantes et de leurs voisins
     */

    public LC neighbours (LC l, int[] CHG, int[] CBD){
        LC<Cellule> n = new LC<>();
        Maillon m = l.tete;

        while (m != null){
            if(m.info instanceof Cellule) {
                Cellule cell = (Cellule) m.info;

                if(cell.determineDansLimite(CHG,CBD)) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                            comptageVoisins(l, neighbour, CHG, CBD);

                            if (i == 0 && j == 0) continue;

                            if (n.estListeVide() || !n.appartientListe(neighbour))
                                n.ajout(neighbour);
                        }
                    }
                }
                m = m.suivant;
            }
        }
        return n;
    }

    /**
     * Variante pour un monde avec limite
     * Calcul la liste chainee correspondant a la generation suivante
     *
     * @param CHG les coordonnées au format [x,y] du coin haut gauche de la limite
     * @param CBD les coordonnées au format [x,y] du coin bas droit de la limite
     * @param l la liste chainee de la generation actuelle
     * @return la liste chainee correspondant a la generation suivante
     */

    public LC nextGen (LC l, int[] CHG, int[] CBD){
        LC<Cellule> res = new LC();
        LC<Cellule> lEtVoisin = neighbours(l,CHG,CBD);

        Maillon m = lEtVoisin.tete;

        while(m!= null){
            Cellule info = (Cellule)m.info;
            int nbVoisin = info.getNbVoisin();

            if(nbVoisin == 2 && l.appartientListe(info))
                res.ajout(info);

            if(nbVoisin == 3)
                res.ajout(info);

            m = m.suivant;
        }

        return res;
    }

    /**
     * Detecte les evolutions
     *
     * @param l la LC de la generation actuelle
     * @return le resultat
     */

    public String detectionEvolution(LC l){
        String res = "Pas d'evolution particuliere";

        if(l.estListeVide()) return "Mort";

        if(!genPreced.estListeVide()) {
            if (l.equal(genPreced.tete.info)) return "Stable";
        }

        return res;
    }
}
