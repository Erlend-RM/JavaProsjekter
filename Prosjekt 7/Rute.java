public abstract class Rute {
    int rad;
    int kolonne;
    Labyrint lab;

    Rute ruteNord;
    Rute ruteSyd;
    Rute ruteVest;
    Rute ruteOest;

    Rute(int rad, int kolonne, Labyrint lab) {
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = lab;
    }

    void settNabo(String retning, Rute rute) {
        if (retning == "nord") {
            ruteNord = rute;
        }
        else if (retning == "oest") {
            ruteOest = rute;
        }
        else if (retning == "syd") {
            ruteSyd = rute;
        }
        else if (retning == "vest") {
            ruteVest = rute;
        }
        else {
            System.out.println("Ikke gyldig retning.");
        }
    }

    abstract public void finn(Rute fra);
}
