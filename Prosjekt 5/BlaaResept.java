public class BlaaResept extends Resept {

    String farge = "blaa";

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String hentReseptInfo(){
        return "blaa";
    }

    @Override
    public String farge() {
        return farge;
    }

    @Override
    public String toString(){
        return super.toString() + "\nFarge paa resept: " + farge + ", rabatt paa 75%. \n";
    }

    @Override
    public int prisAaBetale(int pris){
        return (int)(pris*0.25);  // Eller skal (int) være inne i parantesen?
    }

}
