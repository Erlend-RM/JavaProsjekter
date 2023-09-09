class PResepter extends HvitResept {

    public PResepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public int prisAaBetale() {
        int prisP = legemiddel.hentPris() - 108;
        if (prisP < 0) {
            return 0;
        }
        else {
            return prisP;
        }
    }
}
