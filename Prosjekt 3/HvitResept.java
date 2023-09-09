class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge() {
        return ("Hvit");
    }

    @Override
    public int prisAaBetale() {
        int prisHvit = legemiddel.hentPris();
        return (prisHvit);
    }
}
