public class Trikk {
    
    private String retning;
    private Trikkelinje trikkelinje;
    private String stasjon;

    private Lenkeliste<Stasjon> rute;

    // konstruktør
    public Trikk(String retning, Trikkelinje trikkelinje, String stasjon) {
        this.retning = retning;
        this.trikkelinje = trikkelinje;
        this.stasjon = stasjon;
    }

    // hent retning
    public String hentRetning() { return retning; }

    // hent trikkelinje
    public Trikkelinje hentTrikkelinje() { return trikkelinje; }

    // hent stasjon
    public String hentStasjon() { return stasjon; }

    // initialiserer trikkelinje
    private void initTrikkelinje() {
        rute = trikkelinje.hentLinje();
    }

    // flytter trikken ett stopp i retning vest
    public void kjorVest() {
        int pos;
        for (int i = 0; i < rute.storrelse(); i++) {
            if (rute.hent(i).hentNavn().equals(stasjon.toLowerCase())) {
                pos = i;

                if (pos == 0) stasjon = rute.hent(1).hentNavn();
                else stasjon = rute.hent(i - 1).hentNavn(); 

                return;
            }
        }
    }

    // flytter trikken ett stop i retning øst
    public void kjorOst() {
        int pos;
        for (int i = 0; i < rute.storrelse(); i++) {
            if (rute.hent(i).hentNavn().equals(stasjon.toLowerCase())) {
                pos = i;

                if (pos == rute.storrelse() - 1) stasjon = rute.hent(rute.storrelse() - 2).hentNavn();
                else stasjon = rute.hent(i + 1).hentNavn(); 

                return;
            }            
        }
    }

    // flytter trikken ett stopp i angitt retning, og snur når den når endestasjon
    public void kjor() {
        initTrikkelinje();
        kjorOst();
        System.out.println(stasjon);
    }

}