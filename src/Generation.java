import javafx.scene.control.Cell;

import java.lang.Math;

public class Generation {

    //Fonctionne

    int comptageVoisins(LC l, Cellule c){
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

    public LC Survivre(LC l, int[] x) {
        Maillon m = l.tete;

        while (m != null) {
            for(int i = 0; i < x.length; i++){
                boolean suppression = false;

                if (comptageVoisins(l, ((Cellule) m.info)) == x[i]) {
                    suppression = true;
                }

                if(suppression)
                        l.supprimer1oc((Cellule) m.info);
            }

            m = m.suivant;
        }

        return l;
    }

    public LC naissance(LC l, int x){
        LC<Cellule> dejaFait = new LC<Cellule>();
        Maillon m = l.tete;

        while (m != null){
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    Cellule test = new Cellule(i, j);

                    if(!l.appartientListe(test) && !dejaFait.appartientListe(test))

                        if (comptageVoisins(l, test) == x)
                            l.ajoutEnTete(test);

                    dejaFait.ajoutEnTete(test);
                }
            }
        }

        return l;
    }
}
