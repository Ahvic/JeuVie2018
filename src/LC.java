public class LC{

    Maillon tete;

    public LC(){
        tete = null;
    }

    public boolean estVide(){
        return tete == null;
    }

    public boolean ajout(int[] v){
        Maillon nouv = new Maillon(v,null);

        if(estVide())
            tete = nouv;
        else{
            //Le tri marche pas

            if(!appartientListe(v)){

                Maillon act = tete;
                Maillon pre = null;

                while(act != null){

                    if(act.getInfo()[1] <= v[1] && act.getInfo()[0] <= v[0]){

                        nouv.setSuivant(act);
                        if(pre != null) pre.setSuivant(nouv);
                        else tete = nouv;

                        return true;
                    }
                    else{
                        pre = act;
                        act = act.getSuivant();
                    }

                }

                nouv.setSuivant(tete);
                tete = nouv;
            }
            return false;
        }

        return false;
    }

    public boolean appartientListe(int[] v){
        Maillon m = tete;

        while(m != null){

            if(m.equalsValeur(v)) return true;
            m = m.getSuivant();
        }

        return false;
    }

    public String toString(){
        String res = "";
        Maillon m = tete;

        while(m != null){
            res += m.toString();
            m = m.getSuivant();
        }

        return res;
    }
}
