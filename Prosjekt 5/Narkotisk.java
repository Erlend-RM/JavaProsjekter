public class Narkotisk extends Legemiddel{
    private int styrke;


    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    @Override
    public String hentLegemiddelInfo(){
        String string = "";
        string += super.navn+",narkotisk"+","+super.pris+","+super.virkestoff+","+styrke;
        return string;
    }

    public int hentNarkotiskStyrke(){
        return styrke;
    }

    // Valgfri oppgave, setter inn override toString funksjonen
    @Override
    public String toString(){
        return super.toString() + "\nType: Narkotisk" + "\nStyrke: " + styrke;
    }
}
