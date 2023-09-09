class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge() {
        return ("Blaa");
    }

    @Override
    public int prisAaBetale() {
        int prisBlaa = legemiddel.hentPris() / 4;
        return (prisBlaa);
    }
}
