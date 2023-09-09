public abstract class Resept{
    protected Pasient pasient;
    private int ID;
    static int nyID = 1;
    Lege utskrivendeLege;
    protected int reit;
    Legemiddel legemiddel;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        ID = nyID;
        nyID += 1;
    }

    public int hentId(){
        return ID;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public String hentReseptInfo(){
        return null;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public Pasient hentPasient(){
        return pasient;
    }

    public int hentReit(){
        return reit;
    }


    // Øvrige metoder som blir gitt i oppgaven

    // Metode for å bruke resepten
    public boolean bruk(){
        if (reit == 0){
            return false;  // Legge inn output om feilmelding
        } else {
            reit -= 1;
            return true; }
    }

    abstract public String farge();
    abstract public int prisAaBetale(int pris);

    @Override
    public String toString(){
        return "resept ID: " + ID + "\n" + legemiddel + "\n" + utskrivendeLege+ "\n" +
                 pasient + "\nReit: " + reit;
    }

}
