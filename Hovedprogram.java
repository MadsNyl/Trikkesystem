import java.io.*;
import java.util.Scanner;

public class Hovedprogram {
    public static void main(String[] args) {
        String filnavn = "passasjerer.txt";
        lesInnPassasjerer(filnavn);
    }

    private static void lesInnPassasjerer(String filnavn) {
        try {
            Scanner sc = new Scanner(new File(filnavn));

            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().strip().split(";");
                String navn = linje[0];
                String dra_fra = linje[1];
                String skal_til = linje[2];
                String retning = linje[3];
                boolean harGydligBillett = Boolean.parseBoolean(linje[4]);
                Passasjer passasjer = new Passasjer(navn, dra_fra, skal_til, retning, harGydligBillett);
                System.out.println(passasjer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet.");
            e.printStackTrace();
        }
    }
}
