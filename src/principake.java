import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class principake {

    public static void main(String[] args){

        lectureFichier fichier = new lectureFichier("C:\\Users\\Antoi\\Documents\\GitHub\\JeuVie2018\\exemple lif\\AATest.LIF");

        System.out.println(fichier.ExtractionRegle());
    }

}
