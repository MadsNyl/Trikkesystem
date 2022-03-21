public class Passasjer {
    
    private String navn, dra_fra, skal_til;

    // konstruktør
    public Passasjer(String navn, String dra_fra, String skal_til) {
        this.navn = navn;
        this.dra_fra = dra_fra;
        this.skal_til = skal_til;
    }

    // hent navn
    public String hentNavn() { return navn; }

    // hent stasjon passasjer skal dra fra
    public String hentDraFra() { return dra_fra; }

    // hent stasjon passasjer skal dra til
    public String hentSkalTil() { return skal_til; }

    // sjekker om passasjer skal av
    public boolean skalAv(Stasjon stasjon) { if (stasjon.hentNavn().toLowerCase().equals(skal_til.toLowerCase())) return true; else return false; }

    // overskrider toString metode
    @Override
    public String toString() {
        String retur = "";
        retur += "Passasjernavn: " + navn;
        retur += "\nDrar fra: " + dra_fra;
        retur += "\nSkal til: " + skal_til;

        return retur;
    }

}
