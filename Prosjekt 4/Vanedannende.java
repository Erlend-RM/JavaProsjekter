class Vanedannende extends Legemiddel{
    int stryke;
    int antall;

    Vanedannende(String navn, int pris, double virkestoff, int stryke){
        super(navn, pris, virkestoff);
        this.stryke = stryke;
        antall ++;
        id = antall;
    }

    public int hentVanedannendeStyrke(){
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
