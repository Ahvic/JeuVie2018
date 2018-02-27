import java.util.Arrays;

public class Maillon{

    private Maillon suivant;
    private int[] info;

    public Maillon(int[] info, Maillon suivant){

        //Besoin de tout mettre en positif ou non ?
        //if(info.length != 2 || info[0] < 0 || info[1] < 0 ) throw new IllegalArgumentException();

       this.info = info;
       this.suivant = suivant;
    }

    public Maillon getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon suivant) {
        this.suivant = suivant;
    }

    public int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }

    public boolean equalsValeur(int[] info) {

        if(info.length == this.info.length){
            for(int i = 0; i < this.info.length; i++){
                if(this.info[i] != info[i])
                    return false;
            }

            return true;
        }

        return false;
    }

    public String toString(){

        String res  = "(";

        for(int i = 0; i < info.length; i++)
            if(i != info.length - 1)
                res += info[i] + ",";
            else
                res += info[i];

        return res + ")";
    }
}
