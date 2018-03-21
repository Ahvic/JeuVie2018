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

                            System.out.println(info.ligne + " " + info.colonne);
                        }
                    }
                    else{
                        if(Math.abs(c.colonne - info.colonne) == 1){

                            int dY = Math.abs(c.ligne - info.ligne);

                            if(dY == 1 || dY == 0){
                                res++;
                                System.out.println(info.ligne + " " + info.colonne);
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
}
