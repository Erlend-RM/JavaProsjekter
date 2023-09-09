public class Aapning extends HvitRute {
    
    Aapning (int rad, int kolonne, Labyrint lab) {
        super(rad, kolonne, lab);
    }

    @Override
    public void finn(Rute fra) {
        if(fra != null) {
            System.out.println("Aapning:\n(" + rad + "," + kolonne +")");
        }
        else {
            if (ruteNord != null) {
                ruteNord.finn(this);
            }
            if (ruteOest != null) {
                ruteOest.finn(this);
            }
            if (ruteSyd != null) {
                ruteSyd.finn(this);
            }
            if (ruteVest != null) {
                ruteVest.finn(this);
            }
        }
    }
}
