public class Test {
    public static void main(String[] args) {
        Trikkelinje trikkelinje = new Trikkelinje("13");
        Stasjon jar = new Stasjon("Jar");
        Trikk trikk = new Trikk("vest", trikkelinje, "jar");
        Passasjer person1 = new Passasjer("Mads", "Ljabru", "Jernbanetorget");
        Passasjer person2 = new Passasjer("Jens", "Kastellet", "Thune");
        Passasjer person3 = new Passasjer("Pelle", "Thune", "Kastellet");
        Passasjer person4 = new Passasjer("Knut", "Saeter", "Holtet");

        Lenkeliste<Stasjon> linje = trikkelinje.hentLinje();

        String filnavn = "trikkelinje.txt";

        trikkelinje.lesFil(filnavn);


        trikk.kjor();
    }
}
