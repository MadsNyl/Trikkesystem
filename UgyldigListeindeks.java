class UgyldigListeindeks extends RuntimeException{
    UgyldigListeindeks (int indeks) {
        super("Ugydlig indeks: " + indeks);
    }
}
