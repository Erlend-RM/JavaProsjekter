class MilResept extends HvitResept {
    
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    @Override
    public int prisAaBetale() {
        return 0;
    }
}
