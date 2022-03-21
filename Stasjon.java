public class Stasjon {
    
    private String navn;
    private final int PLASSER = 1;
    private Passasjer[] antallPlasser = new Passasjer[PLASSER];
    private int fyltePlasser = 0, ledigePlasser = PLASSER;


    // konstruktør
    public Stasjon(String navn) {
        this.navn = navn;
    }

    // hent navn
    public String hentNavn() { return navn; }

    // hent antallPlasser
    public int hentAntallPlasser() { return antallPlasser.length; }

    // hent fylte plasser
    public int hentFyltePlasser() { return fyltePlasser; }

    // hent ledige plasser
    public int hentLedigePlasser() { return ledigePlasser; }

    // hent liste over passasjerer på stasjonen
    public Passasjer[] hentListeOvePassasjerer() { return antallPlasser; }

    // henter ut gitt antall passasjerer
    public void hentUtMaxAntallPassasjerer(int antall) {
        if (antall <= fyltePlasser) for (int i = 0; i < antall; i++) fjernPassasjer(i);
        else if (antall > fyltePlasser) for (int i = 0; i < antallPlasser.length; i++) fjernPassasjer(i);
    }

    // legg til en passasjer og fyll opp en plass
    public void plasserPassasjer(Passasjer passasjer) {
        for (int i = 0; i < antallPlasser.length; i++) {
            if (antallPlasser[i] == null) {
                antallPlasser[i] = passasjer;
                ledigePlasser--;
                fyltePlasser++; 
                return;
            }
        }
    }

    // hent ut en passasjer og frigjør en plass
    public void fjernPassasjer(int pos) {
        if (antallPlasser[pos] != null) {
            antallPlasser[pos] = null;
            ledigePlasser++;
            fyltePlasser--;
            return;
        }
    }

    // se alle passasjerer
    public void seAllePassasjerer() { for (int i = 0; i < antallPlasser.length; i++) System.out.println(antallPlasser[i]); }

    // plasserer en passasjer inn på en ledig plass på stasjonen
    public void passasjerAnkommerStasjon(Passasjer passasjer) {
        if (antallPlasser.length > fyltePlasser) {
            plasserPassasjer(passasjer);
        } else {
            Passasjer[] ny_liste = new Passasjer[antallPlasser.length * 2];
            ledigePlasser = ny_liste.length - antallPlasser.length;
            for (int i = 0; i < antallPlasser.length; i++) {
                ny_liste[i] = antallPlasser[i];
            }
            antallPlasser = ny_liste;
            plasserPassasjer(passasjer);
        }
    }

    // overskrider toString metode
    @Override
    public String toString() { return navn; }
}
