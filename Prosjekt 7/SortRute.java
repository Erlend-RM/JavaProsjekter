public class SortRute extends Rute {
    
    SortRute (int rad, int kolonne, Labyrint lab) {
        super(rad, kolonne, lab);
    }

    @Override
    public void finn(Rute fra) {
        if(fra == null) {
            System.out.println("Kan ikke starte fra sort rute.");
        }
    }

    @Override
    public String toString() {
        return " # ";
    }
}
