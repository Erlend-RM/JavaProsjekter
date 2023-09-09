public class Pasient {

    public String navn;
    public String foedselsNr;
    private int ID;
    static int nyID = 1;
    private Stabel<Resept> resepter = new Stabel<>();

    public Pasient(String navn, String foedselsNr){
        this.navn = navn;
        this.foedselsNr = foedselsNr;
        ID = nyID;
        nyID ++;
    }

    public void leggTil(Resept resept){
        resepter.leggTil(resept);
    }

    /* String list = resepter.toString();
    System.out.println("String: " + list);*/

    /*@Override
    public String toString(){
        return "resepter: " + resepter;
    }*/

    public Stabel<Resept> hentPasientReseptListe(){
        return resepter;
    }

    public int hentPasientID(){
        return ID;
    }

    public String hentPasientInfo(){
        String string = "";
        string += navn+","+foedselsNr;
        return string;
    }


    @Override
    public String toString(){
        return "Pasient ID: "+ ID +"\nNavn på pasient: " + navn;
    }

}
