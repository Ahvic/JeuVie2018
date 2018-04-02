import javafx.scene.control.Cell;

public class LC<T> {

    Maillon<T> tete;

    LC(){
        tete = null;
    }

    public int minimumColonne(){
        Maillon<T> m = tete;
        int res = ((Cellule)(m.info)).colonne;

        while(m != null){
            int valeur = ((Cellule)(m.info)).colonne;

            if(valeur < res)
                res = valeur;

            m = m.suivant;
        }

        return res;
    }

    public int minimum(){
        Maillon<T> m = tete;
        int res = ((Cellule)(m.info)).colonne;

        while(m != null){
            int valeur = ((Cellule)(m.info)).colonne;

            if(valeur < res)
                res = valeur;

            m = m.suivant;
        }

        return res;
    }

    public void ajoutEnTete(T v){
        if(!appartientListe(v)) tete = new Maillon<T>(v, tete);
    }

    public Maillon<T> teteListe(){
        return tete;
    }

    public T elementTete(){
        return tete.info;
    }

    public boolean estListeVide(){
        return (this.tete == null);
    }

    public boolean appartientListe(T x){
        Maillon<T> m = tete;

        while(m != null){
            if(m.info == x) return true;
            m = m.suivant;
        }

        return false;
    }

    public LC<T> supprimer1oc(T x){

        if(estListeVide()) return this;

        if(tete.info == x){
            tete = tete.suivant;
            return this;
        }

        Maillon<T> m = tete.suivant;
        Maillon<T> pre = tete;

        while(m != null){

            if(m.info == x){
                pre.suivant = m.suivant;
                return this;
            }
            else{
                pre = m;
                m = m.suivant;
            }

        }

        return this;
    }

    public boolean equal(LC<T> l){
        Maillon<T> m = tete;
        Maillon<T> p = l.tete;

        while(m != null){
            if(m.info != p.info) return false;
            m = m.suivant;
            p = p.suivant;
        }


        return true;
    }

    public String toString(){
        String s = "";

        if(estListeVide()) return s;

        Maillon<T> m = tete;

        while(m != null){

            T info = m.info;

            if(info instanceof Cellule){
                s += "(" + ((Cellule) info).colonne + "," + ((Cellule) info).ligne + ")";
            }
            else{
                s +=  m.info.toString() + "\n";
            }

            m = m.suivant;
            System.out.println(s);
        }

        return s;
    }

    /**
     * Affiche la liste chainee sous la forme d'un tableau
     *
     * 2 parcours de la liste chainée et un d'un tableau, pas efficace
     *
     * @return le tableau
     */

    public String affichageTableau(){
        String res = "";
        LC<String> l = new LC<String>();
        Maillon m = tete;
        Maillon pM = null;
        int minColonne = ((Cellule)m.info).colonne;

        //m ne change hors de la boucle que lorsqu'on change de ligne
        while(m != null) {

            System.out.println(m.info + "dans la 1e boucle");

            Cellule info = (Cellule) m.info;
            Cellule infoP = null;
            String ligne = "";

            if (minColonne > info.colonne) {
                Maillon mL = l.tete;
                int decalage = Math.abs(minColonne - info.colonne);
                String ajout = "";

                for (int i = 0; i < decalage; i++)
                    ajout += ".";

                while (mL != null) {
                    mL.info = ajout + mL.info;
                }

                minColonne = info.colonne;
            }
            else {
                int decalage = Math.abs(info.colonne - minColonne);

                for (int i = 0; i < decalage; i++)
                    ligne += ".";
            }

            while (infoP == null || info.ligne == infoP.ligne) {
                if (infoP != null) {
                    int decalage = Math.abs(info.colonne - infoP.colonne) - 1;
                    String ajout = "";

                    for (int i = 0; i < decalage; i++)
                        ajout += ".";

                    ajout += "*";

                } else {
                    ligne += "*";
                }

                System.out.println(m.info + "dans la 2e boucle");

                pM = m;
                m = m.suivant;
                info = (Cellule) m.info;
                infoP = (Cellule) pM.info;
            }

            l.ajoutEnTete(ligne);
        }

        Maillon n = l.tete;

        System.out.println("Marqueur 2");

        while(n != null){
            res += n.info + "\n";
            n = n.suivant;
        }

        return res;
    }
}