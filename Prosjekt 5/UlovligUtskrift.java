class UlovligUtskrift extends Exception {
    // Potensielt legge inn resept her
    UlovligUtskrift (Lege l, Legemiddel lm) {
        super("Legen "+l.hentLege()+" har ikke lov til aa skrive ut "+lm.hentNavn());
    }
}