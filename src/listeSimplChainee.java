public class listeSimplChainee<T> {
    /*
    Maillon<T> tete;

    listeSimplChainee(){
        tete = null;
    }

    public void ajout(T v){

        //Marche pas

        if(!appartientListe(v)){

            if(tete == null)
                tete = new Maillon<T>(v,null);
            else{

            }
        }

        Maillon<T> nouv = new Maillon<T>(v,null);
        tete.setSuivant(nouv);
        tete = nouv;

        //Maillon<T> m = tete.getSuivant();
        //Maillon<T> prec = tete;
        /*
        while(m != null){

            int[] infoM = (int[]) m.getInfo();
            int[] infoV = (int[]) m.getInfo();


            if(infoM[1] < infoV[1] && infoM[0] < infoV[0]){
                prec.setSuivant(nouv);
                nouv.setSuivant(m);
            }
            else{
                prec = m;
                m = m.getSuivant();
            }

        }

    }

    public Maillon<T> teteListe(){
        return tete;
    }

    public T elementTete(){
        return tete.getInfo();
    }

    public boolean estListeVide(){
        return (this.tete == null);
    }

    public boolean appartientListe(T x){
        Maillon<T> m = tete;

        while(m != null){
            if(m.getInfo() == x) return true;
            m = m.getSuivant();
        }

        return false;
    }

    public listeSimplChainee<T> supprimer1oc(T x){

        if(estListeVide()) return this;

        if(tete.getInfo() == x){
            tete = tete.getSuivant();
            return this;
        }

        Maillon<T> m = tete.getSuivant();
        Maillon<T> pre = tete;

        while(m != null){

            if(m.getInfo() == x){
                pre.setSuivant(m.getSuivant());
                return this;
            }
            else{
                pre = m;
                m = m.getSuivant();
            }

        }

        return this;
    }

    public boolean equal(listeSimplChainee<T> l){
        Maillon<T> m = tete;
        Maillon<T> p = l.tete;

        while(m != null){
            if(m.getInfo() != p.getInfo()) return false;
            m = m.getSuivant();
            p = p.getSuivant();
        }


        return true;
    }

    public String toString(){
        String s = "";

        if(estListeVide()) return "vide";

        Maillon<T> m = tete;

        while(m != null){
            s += m.toString();
            m = m.getSuivant();
        }

        return s;
    }
    */
}
