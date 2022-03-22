public class Test {
    public static void main(String[] args) {
        Trikkelinje trikkelinje = new Trikkelinje("13");
        Stasjon jar = new Stasjon("Jar");
        Trikk trikk = new Trikk("vest", trikkelinje, jar);
        Passasjer person1 = new Passasjer("Mads", "Ljabru", "Jernbanetorget", null, null);
        Passasjer person2 = new Passasjer("Jens", "Kastellet", "Thune", null, null);
        Passasjer person3 = new Passasjer("Pelle", "Thune", "Kastellet", null, null);
        Passasjer person4 = new Passasjer("Knut", "Saeter", "Holtet", null, null);

        Lenkeliste<Stasjon> linje = trikkelinje.hentLinje();

        String filnavn = "trikkelinje.txt";

        trikkelinje.lesFil(filnavn);


        trikk.kjor();
    }
}
