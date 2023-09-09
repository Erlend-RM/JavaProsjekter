public class PResepter extends HvitResept{

    public PResepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public int prisAaBetale(int pris) {
        return Math.max(pris - 108, 0);
    }

    @Override
    public String hentReseptInfo(){
        return "p";
    }

    @Override
    public String toString(){
        return super.toString()+"PResept\n";
    }
}
