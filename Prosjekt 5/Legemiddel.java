public abstract class Legemiddel{  // Siden et legemiddel skal være en av subklasssene gjør vi den abstract
    protected String navn;
    protected int ID;
    static int nyID = 1;
    public int pris;  // Denne settes public siden vi skal kunne endre pris
    protected double virkestoff;

    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        ID = nyID;
        nyID += 1;
    }


    public String hentLegemiddelInfo(){
        return null;
    }

    public int hentId(){
        return ID;
    }

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return virkestoff;
    }

    public void settNyPris(int nyPris){  // Vi gjør denne void siden den ikke skal returnere noen verdi
        pris = nyPris;
    }

    // Valgfri oppgave, setter inn override toString funksjonen
    @Override
    public String toString(){
        return "Navn på legemiddel: " + navn + "\nID på legemiddel: " + ID + "\nVirkestoff: " + virkestoff + "\nPris: " + pris;
    }
}
