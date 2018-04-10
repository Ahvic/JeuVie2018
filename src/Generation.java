import javafx.scene.control.TableColumn;

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
                            System.out.print(info.toString());
                        }
                    }
                    else{
                        if(Math.abs(c.colonne - info.colonne) == 1){

                            int dY = Math.abs(c.ligne - info.ligne);

                            if(dY == 1 || dY == 0){
                                res++;
                                System.out.print(info.toString());
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

    public LC birth (LC l, int x){
        LC<Cellule> done = new LC<Cellule>();
        Maillon m = l.tete;
        int a = 0;
        int b = 0;
        while (m != null){
            Cellule cell = (Cellule)m.info;
            //System.out.println(cell.toString());
            //System.out.println("nombre de voisins : " + comptageVoisins(l, cell));
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    Cellule neighbour = new Cellule(cell.colonne + i, cell.ligne + j);
                    System.out.println("cellule : " + neighbour.toString());
                    System.out.println("voisins : " + comptageVoisins(l, neighbour));
                    if (i == 0 && j == 0) continue;
                    if (done.appartientListe(neighbour)) b++;
                    if(!l.appartientListe(neighbour) && !done.appartientListe(neighbour)){
                        if (comptageVoisins(l, neighbour) == x) {
                            done.ajoutEnTete(neighbour);
                            l.ajoutEnTete(neighbour);
                            a ++;
                        }
                    }



                }
            }
            m = m.suivant;
        }
        System.out.println(b);
        return l;
    }
}
