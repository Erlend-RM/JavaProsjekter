class Vanlig extends Legemiddel{
    int antall;
    
    Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
        antall ++;
        id = antall;
    }

    @Override
    public int hentId() {
        return id;
    }
}
