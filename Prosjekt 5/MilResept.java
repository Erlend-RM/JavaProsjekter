public class MilResept extends HvitResept {

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient, 3);
    }
    @Override
    public String hentReseptInfo(){
        return "militaer";
    }

    @Override
    public int prisAaBetale(int pris){
        return 0;  // Returnerer alltid 0 siden de er 100% rabattert
    }

    @Override
    public String toString(){
        return super.toString()+"Militærresept, 100% rabattert.\n";
    }

}
