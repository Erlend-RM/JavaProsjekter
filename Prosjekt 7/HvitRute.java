public class HvitRute extends Rute {
    Rute brukt = null;
    
    
    HvitRute (int rad, int kolonne, Labyrint lab) {
        super(rad, kolonne, lab);
    }

    @Override
    public void finn(Rute fra) {
        Rute[] naboer = {this.ruteNord, this.ruteOest, this.ruteSyd, this.ruteVest};
        if(fra == null) {
            ruteNord.finn(this);
            ruteOest.finn(this);
            ruteSyd.finn(this);
            ruteVest.finn(this);
        }
        else {
            for (Rute nabo : naboer) {
                if (nabo != null && nabo != fra) {
                    nabo.finn(this);
                }
            }

            /*if(fra.equals(ruteNord)) {
                ruteOest.finn(this);
                ruteSyd.finn(this);
                ruteVest.finn(this);
            }
            else if(fra.equals(ruteOest)) {
                ruteNord.finn(this);
                ruteSyd.finn(this);
                ruteVest.finn(this);
            }
            else if(fra.equals(ruteSyd)) {
                ruteNord.finn(this);
                ruteOest.finn(this);
                ruteVest.finn(this);
            }*/
        }
        

        
    }

    @Override
    public String toString() {
        return " . ";
    }
}