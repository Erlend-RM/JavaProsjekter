class Narkotisk extends Legemiddel {
    int stryke;
    int antall;

    Narkotisk(String navn, int pris, double virkestoff, int stryke) {
        super(navn, pris, virkestoff);
        this.stryke = stryke;
        antall ++;
        id = antall;

    }

    public int hentNarkotiskStyrke() {
        return stryke;
    }

    @Override
    public int hentId() {
        return id;
    }

    @Override
    public String toString(){
        return ("Navn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff + "\nStryke: " + stryke);
    }
}
