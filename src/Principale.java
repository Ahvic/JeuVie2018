import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] Args){

        LC liste = new LC();

        lectureFichier lf = new lectureFichier("C:\\Users\\Antoi\\Downloads\\exemple lif.tar\\exemple lif\\ACORN.LIF");
        lf.ExtractionCellule();
    }

}
