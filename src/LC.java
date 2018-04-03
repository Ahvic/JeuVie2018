
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
     * Marche mais degeu
     *
     * @return le tableau
     */

    public String affichageTableau(){
        Maillon m = tete;
        Maillon pre = null;
        LC<LigneAfficheur> mem = new LC<LigneAfficheur>();
        String ligneAct = "";
        Cellule info = (Cellule)m.info;
        Cellule infoP = null;
        int minMem = info.colonne;

        while(m != null){
            info = (Cellule)m.info;
            infoP = null;

            if(pre == null){
                ligneAct += "*";
            }else{
                infoP = (Cellule)pre.info;
                int dX = infoP.colonne - info.colonne;
                int dY = infoP.ligne - info.ligne;

                //Passage a la ligne suivante
                if(dY > 0){
                    for(int i = dY; i > 0; i--) {
                        mem.ajoutEnTete(new LigneAfficheur(ligneAct, infoP.colonne));
                        ligneAct = "";
                        dX = 1;
                        if(infoP.colonne < minMem)
                            minMem = infoP.colonne;
                    }
                }

                //Creation de la ligne
                if(dX > 0){
                    //Ajout a gauche
                    for (int i = dX - 1; i > 0; i--)
                        ligneAct = " " + ligneAct;
                    ligneAct = "*" + ligneAct;
                }else{
                    //Ajout a droite
                    for (int i = dX; i < 0; i++)
                        ligneAct += " ";
                    ligneAct += "*";
                }
            }

            pre = m;
            m = m.suivant;
        }

        mem.ajoutEnTete(new LigneAfficheur(ligneAct, info.colonne));
        if(info != null){
            if(info.colonne < minMem)
                minMem = info.colonne;
        }

        Maillon n = mem.tete;

        String res = "";

        while (n != null){
            LigneAfficheur l = (LigneAfficheur) n.info;
            int decalage = Math.abs(minMem - l.minimum);

            for(int i = 0; i < decalage; i++){
                res += " ";
            }

            res += l.contenu + "\n";
            n = n.suivant;
        }

        return res;
    }
}