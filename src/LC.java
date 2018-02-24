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

        if(estVide()) {
            tete = nouv;
        }
        else{
            nouv.setSuivant(tete);
            tete = nouv;
        }

        return true;
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
