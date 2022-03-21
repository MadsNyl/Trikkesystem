public class Lenkeliste<T> {
    // indre klasse Node
    class Node{
        protected Node neste = null, forrige = null;
        T data;

        // konstruktør
        Node(T data) {
            this.data = data;
        }

        // overskrider toString metode
        @Override
        public String toString() {
            return data.toString();
        }
    }

    // oppretter pekere
    protected Node start = null, slutt = null;

    // finn størrelse
    public int storrelse() {
        int storrelse = 0;
        Node peker = start;

        // hvis listen er tom
        if (peker == null) return 0;

        while (peker != null) {
            peker = peker.neste;
            storrelse++;
        }

        return storrelse;
    }

    // legg til node i starten av liste
    public void leggTil(T x) {
        Node ny = new Node(x);

        //hvis listen er tom
        if (storrelse() == 0) {
            start = ny;
            slutt = ny;
            slutt.forrige = ny;
        } else {
            start.forrige = ny;
            ny.neste = start;
            start = ny;
        }
    }

    // legg til node i gitt posisjon
    public void leggTil(int pos, T x) throws UgyldigListeindeks {
        Node ny = new Node(x);
        Node peker = start;

        // hvis pos er utenfor indeks
        if (pos < 0 || storrelse() < pos) throw new UgyldigListeindeks(pos);

        // hvis pos er starten av liste
        if (pos == 0) this.leggTil(x);
        // hvis pos er slutten av liste
        else if (pos == storrelse()) {
            ny.forrige = slutt;
            slutt.neste = ny;
            slutt = ny;
        } else {
            for (int i = 0; i < pos - 1; i++) peker = peker.neste;

            ny.neste = peker.neste;
            ny.forrige = peker;
            peker.neste.forrige = ny;
            peker.neste = ny;
        }
    }

    // hent node i gitt posisjon
    public T hent(int pos) throws UgyldigListeindeks {
        Node peker = start;

        // hvis pos er utenfor indeks
        if (pos < 0 || storrelse() - 1 < pos) throw new UgyldigListeindeks(pos);

        // hvis pos er start av listen
        if (pos == 0) return peker.data;
        // hvis pos er slutt av listen
        if (pos == storrelse()) return slutt.data;

        for (int i = 0; i < pos; i++) peker = peker.neste;

        return peker.data;
    }
}
