public class Vanedannende extends Legemiddel{

    private int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    @Override
    public String hentLegemiddelInfo(){
        String string = "";
        string += super.navn+",vanedannende"+","+super.pris+","+super.virkestoff+","+styrke;
        return string;
    }

    public int hentVanedannendeStyrke(){
        return styrke;
    }


    // Valgfri oppgave, setter inn override toString funksjonen
    @Override
    public String toString(){
        return super.toString() + "\nType: Vanedannende" + "\nStyrke: " + styrke;
    }
}
