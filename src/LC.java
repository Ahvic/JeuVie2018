
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
     * @return le tableau
     */

    public String affichageTableau(){
        String res = "";
        Maillon m = tete;
        Maillon pre = null;

        while(m != null){
            Cellule info = (Cellule)m.info;
            Cellule infoP = null;

            if(pre == null){
                res += "*";
            }else{
                infoP = (Cellule)pre.info;
                int dX = infoP.colonne - info.colonne;
                int dY = infoP.ligne - info.ligne;

                //on ne prend en compte que le cas ou on remonte vu que la LC est trie
                if(dY > 0){
                    for(int i = dY; i > 0; i--)
                        res += "\n";
                }

                if(dX > 0){
                    //Ajout a gauche
                    for (int i = dX - 1; i > 0; i--)
                        res = "." + res;
                    res = "*" + res;
                }else{
                    //Ajout a droite
                    for (int i = dX; i < 0; i++)
                        res += ".";
                    res += "*";
                }

                System.out.println("Act: " + info + " pre : " + infoP + "| dX :" + dX + " dY : " + dY);
                System.out.println(res);
            }

            pre = m;
            m = m.suivant;
        }

        return res;
    }
}