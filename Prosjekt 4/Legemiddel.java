abstract class Legemiddel{
    protected String navn;
    protected static int id;
    protected int pris;
    protected double virkestoff;

    Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id++;
    }

    public abstract int hentId();

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVrikestoff(){
        return virkestoff;
    }

    public int settNyPris(int nyPris){
        pris = nyPris;
        return pris;
    }

    @Override
    public String toString(){
        return ("Navn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff);
    }
}