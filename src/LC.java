import javafx.scene.control.Cell;

public class LC<T> {

    Maillon<T> tete;

    LC(){
        tete = null;
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
        }

        return s;
    }

    /**
     * Affiche la liste chainee sous la forme d'un tableau
     *
     * Marche pas
     *
     * @return le tableau
     */

    public String toStringTab(){
        String s = "";

        if(estListeVide()) return "Liste vide";

        Maillon<T> m = tete;
        Cellule pC = (Cellule) m.info;

        while(m != null){
            Cellule mC = (Cellule)m.info;

            if((mC.ligne) != pC.ligne){
                for(int i = 0; i < Math.abs(pC.ligne - mC.ligne); i++)
                    s += "\n";
            }

            if(pC == mC) s += "*";
            else{
                for(int i = 0; i < Math.abs(pC.colonne - mC.colonne); i++)
                    s += " ";
                s += "*";
            }

            pC = mC;
            m = m.suivant;
        }

        return s;
    }
}
