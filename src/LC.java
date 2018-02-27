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

    public String toStringTab(){

        //Deux itérations obligatoires ? L'un construit le tableau, l'autre cherche les valeurs
        String res = "   ";
        Maillon m = tete;
        int[] info = tete.getInfo();

        int minX = info[0];
        int maxX = info[0];
        int minY = info[1];
        int maxY = info[1];

        while(m != null){
            int[] infoM = m.getInfo();

            if(infoM[0] < minX) minX = infoM[0];
            if(infoM[0] > maxX) maxX = infoM[0];
            if(infoM[1] < minY) minY = infoM[1];
            if(infoM[1] > maxY) maxY = infoM[1];

            m = m.getSuivant();
        }

        //Manque un gros truc

        return res;
    }
}
