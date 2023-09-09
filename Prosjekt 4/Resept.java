abstract class Resept {
    
    private int idResept;
    private static int antallRespet;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;


    Resept (Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        antallRespet++;
        idResept = antallRespet;
    }

    public int hentId() {
        return idResept;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public int hentPasientId() {
        return pasientId;
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit > 0) {
            reit -= 1;
            return true;
        }
        else {
            return false;
        }
    }

    abstract public String farge();

    abstract public int prisAaBetale();

    @Override
    public String toString() {
        return ("Respt ID: " + idResept + "\n" + legemiddel + "\n" + utskrivendeLege + "\nPasient ID: " + pasientId + "\nReit: " + reit + "\nFarge: " + farge());
    }
}
