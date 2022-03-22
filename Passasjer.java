public class Passasjer {
    
    private String navn, dra_fra, skal_til, retning;
    private boolean harGydligBillett;

    // konstruktør
    public Passasjer(String navn, String dra_fra, String skal_til, String retning, Boolean harGydligBillett) {
        this.navn = navn;
        this.dra_fra = dra_fra.toLowerCase();
        this.skal_til = skal_til.toLowerCase();
        this.retning = retning.toLowerCase();
        this.harGydligBillett = harGydligBillett;
    }

    // hent navn
    public String hentNavn() { return navn; }

    // hent stasjon passasjer skal dra fra
    public String hentDraFra() { return dra_fra; }

    // hent stasjon passasjer skal dra til
    public String hentSkalTil() { return skal_til; }

    // hent retning
    public String hentRetning() { return retning; }

    // sjekker om passasjer har gyldig billett
    public boolean harGydligBillett() { return harGydligBillett; }

    // sjekker om passasjer skal av
    public boolean skalAv(Stasjon stasjon) { if (stasjon.hentNavn().toLowerCase().equals(skal_til.toLowerCase())) return true; else return false; }

    // overskrider toString metode
    @Override
    public String toString() {
        String retur = "";
        retur += "Passasjernavn: " + navn;
        retur += "\nDrar fra: " + dra_fra;
        retur += "\nSkal til: " + skal_til;
        retur += "\nRetning: " + retning;
        retur += "\nHar gyldig billett: " + harGydligBillett;

        return retur;
    }

}
