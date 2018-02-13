public class Maillon {

    private Maillon suivant;
    private int[] position = new int[2];

    public Maillon(int x, int y){
        position[0] = x;
        position[1] = y;
        suivant = null;
    }

    public int[] getPosition() {
        return position;
    }

    public void changementSuivant(Maillon m){
        suivant = m;
    }

}
