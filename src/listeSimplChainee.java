public class listeSimplChainee {

    private Maillon sommet = null;

    public listeSimplChainee(int x, int y){
        sommet = new Maillon(x,y);
    }

    public boolean Existe(int x, int y){
        Maillon m = sommet;

        return false;

    }

    public boolean Ajout(int x, int y){

        if(x >= 0 && y >= 0){
            sommet.changementSuivant(new Maillon(x,y));
            return true;
        }

        return false;
    }

    public boolean Retrait(int x, int y){

        Maillon m = sommet;

        if(x >= 0 && y >= 0){
            while(m != null){
                int[] pos = m.getPosition();

                if(pos[0] == x && pos[1] == y){

                }
            }
            return false;
        }

        return false;

    }

}
