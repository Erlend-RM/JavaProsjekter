class Lege {
    
    String legensNavn;

    Lege(String legensNavn) {
        this.legensNavn = legensNavn;
    }

    public String hentLegensNavn() {
        return legensNavn;
    }

    @Override
    public String toString() {
        return ("Navn lege: " + legensNavn);
    }
}
