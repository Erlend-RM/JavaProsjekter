public class HvitResept extends Resept{
    String farge = "hvit";

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }
    @Override
    public String farge() {
        return farge;
    }

    @Override
    public String hentReseptInfo(){
        return "hvit";
    }

    @Override
    public String toString(){
        return super.toString() + "\nFarge på resept: " + farge+"\n";
    }

    @Override
    public int prisAaBetale(int pris){
        return pris;
    }
}
