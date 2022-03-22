import java.io.*;
import java.util.Scanner;

public class Trikkelinje {
    
    private String navn;
    private Stasjon endestasjon_vest, endestasjon_ost; 
    private Lenkeliste<Stasjon> linje = new StasjonsBeholder();

    // konstruktør
    public Trikkelinje(String navn) {
        this.navn = navn;
    }

    // hent navn
    public String hentNavn() { return navn; }

    // hent lengde på ruten
    public int hentLinjeLengde() { return linje.storrelse(); }

    // hent linje
    public Lenkeliste<Stasjon> hentLinje() { return linje; }

    // hent endstasjon_vest
    public Stasjon hentEndestasjonVest() { return endestasjon_vest; }

    // hent endestasjon_ost
    public Stasjon hentEndestasjonOst() { return endestasjon_ost; }

    // se alle stasjoner
    public void seAlleStasjoner() { for (int i = 0; i < linje.storrelse(); i++) System.out.println(linje.hent(i)); }

    // setter inn stasjon fra vest
    public void settInnStasjonFraVest(int pos, Stasjon stasjon) throws UgyldigListeindeks { linje.leggTil(pos, stasjon); }

    // leser inn stasjon fra fil og legger til i linjen
    public void lesFil(String filnavn) {
        try {
            int teller = 0;
            Scanner sc = new Scanner(new File(filnavn));

            while (sc.hasNextLine()) {
                String linje = sc.nextLine().strip();
                Stasjon stasjon = new Stasjon(linje.toLowerCase());
                settInnStasjonFraVest(teller++, stasjon);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet.");
            e.printStackTrace();
        }
    }

    // overskrider toString metode
    @Override
    public String toString() {
        String retur = "";
        retur += "Linje: " + navn;

        for (int i = 0; i < linje.storrelse(); i++) retur += "\n - " + linje.hent(i);
        
        return retur;
    }
}
