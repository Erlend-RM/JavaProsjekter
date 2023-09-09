public class Vanlig extends Legemiddel{


    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }

    @Override
    public String hentLegemiddelInfo(){
        String string = "";
        string += super.navn+",vanlig"+","+super.pris+","+super.virkestoff;
        return string;
    }
}
