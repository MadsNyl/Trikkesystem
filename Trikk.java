public class Trikk {
    
    private String retning;
    private Trikkelinje trikkelinje;
    private Stasjon stasjon;

    private Lenkeliste<Stasjon> rute;

    // konstruktør
    public Trikk(String retning, Trikkelinje trikkelinje, Stasjon stasjon) {
        this.retning = retning.toLowerCase();
        this.trikkelinje = trikkelinje;
        this.stasjon = stasjon;
    }

    // hent retning
    public String hentRetning() { return retning; }

    // hent trikkelinje
    public Trikkelinje hentTrikkelinje() { return trikkelinje; }

    // hent stasjon
    public Stasjon hentStasjon() { return stasjon; }

    // initialiserer trikkelinje
    private void initTrikkelinje() {
        rute = trikkelinje.hentLinje();
    }

    // flytter trikken ett stopp i retning vest
    public void kjorVest() {
        int pos;
        for (int i = 0; i < rute.storrelse(); i++) {
            if (rute.hent(i).hentNavn().equals(stasjon.hentNavn().toLowerCase())) {
                pos = i;

                if (pos == 0) stasjon = rute.hent(1);
                else stasjon = rute.hent(i - 1); 

                return;
            }
        }
    }

    // flytter trikken ett stop i retning øst
    public void kjorOst() {
        int pos;
        for (int i = 0; i < rute.storrelse(); i++) {
            if (rute.hent(i).hentNavn().equals(stasjon.hentNavn().toLowerCase())) {
                pos = i;

                if (pos == rute.storrelse() - 1) stasjon = rute.hent(rute.storrelse() - 2);
                else stasjon = rute.hent(i + 1); 

                return;
            }            
        }
    }

    // flytter trikken ett stopp i angitt retning, og snur når den når endestasjon
    public void kjor() {
        initTrikkelinje();
        if (retning.equals("ost")) kjorOst();
        else if (retning.equals("vest")) kjorVest();
        else System.out.println("Angitt retning er feil. Kun vest og ost er godkjente retninger.");
    }

}