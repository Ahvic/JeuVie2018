import java.util.Arrays;

public class Maillon<T>{

    private Maillon<T> suivant;
    private T info;

    public Maillon(T info, Maillon<T> suivant){
       this.info = info;
       this.suivant = suivant;
    }

    public Maillon<T> getSuivant() {
        return suivant;
    }

    public void setSuivant(Maillon<T> suivant) {
        this.suivant = suivant;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String toString(){

        if(info instanceof int[]){
            String res  = "(";
            int[] m = (int[]) info;

            for(int i = 0; i < m.length; i++)
                if(i != m.length - 1)
                    res += m[i] + ",";
                else
                    res += m[i];

            return res + ")";
        }

        return info.toString();
    }
}
