import junit.framework.TestCase;
import org.junit.*;

public class LCTest extends TestCase {

    public LCTest(){
        super("LC.class");
    }

    @Test
    public void testAjoutEnTete() {
        LC<Integer> liste = new LC<>();
        liste.ajoutEnTete(5);
        int info = liste.getTete().info;
        assertEquals(5,info);
    }

    @Test
    public void testAjout() {
        LC<Integer> liste = new LC<>();
        liste.ajout(5);
        int info = liste.getTete().info;
        assertEquals(5,info);
    }

    @Test
    public void testGetTete() {
        LC<Integer> liste = new LC<>();
        liste.ajoutEnTete(5);
        int info = liste.getTete().info;
        assertEquals(5,info);
    }

    @Test
    public void testEstListeVide() {
        LC<Integer> liste = new LC<>();
        assertEquals(true,liste.estListeVide());

        liste.ajout(5);
        assertEquals(false,liste.estListeVide());
    }

    @Test
    public void testAppartientListe() {
        LC<Integer> liste = new LC<>();
        assertEquals(false,liste.appartientListe(5));

        liste.ajoutEnTete(5);
        assertEquals(true,liste.appartientListe(5));
    }

    @Test
    public void testEqual() {
        LC<Integer> liste = new LC<>();
        liste.ajoutEnTete(5);

        LC<Integer> liste2 = new LC<>();
        liste2.ajoutEnTete(4);

        assertEquals(false,liste.equal(liste2));

        LC<Integer> liste3 = new LC<>();
        liste3.ajoutEnTete(5);

        assertEquals(true,liste.equal(liste3));
    }

    @Test
    public void testToString() {
        LC<Integer> liste = new LC<>();
        assertEquals("LC vide",liste.toString());

        liste.ajoutEnTete(5);
        assertEquals("5",liste.toString());
    }

    @Test
    public void testAffichageTableau() {
        LC<Integer> liste = new LC<>();
        assertEquals("LC vide",liste.affichageTableau());

        liste.ajoutEnTete(5);
        assertEquals("",liste.affichageTableau());
    }
}
