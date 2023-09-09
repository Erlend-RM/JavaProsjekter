public class Kontroll {
    private GUI gui;
    private Modell modell;
    private Rettning rettning = Rettning.HOEYRE;
    boolean tap = false;

    Kontroll () {
        gui = new GUI(this);
        modell = new Modell(gui, this);
        Thread traad = new Thread(new Teller());
        settStartSlange();
        skrivUtSlange();
        settEpler();
        traad.start();
    }

    void oekPoeng() {
        modell.oekPoeng();
    }

    void nullStillPoeng() {
        modell.nullStillPoeng();
    }

    void avslutt() {
        System.exit(0);
    }

    void settStartSlange() {
        modell.settStartSlange();
    }

    void skrivUtSlange() {
        modell.skrivUtSlange();
    }

    void settEpler() {
        modell.plasserEpler();
    }

    class Teller implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e) {
                    return;
                }
                flytt();
                if (tap) {
                    return;
                }
            }
        }
    }

    private void flytt() {
        modell.flytt(rettning);
    }

    void settRettning(Rettning rettning) {
        this.rettning = rettning;
    }

    void tap() {
        modell.tap();
    }

    public static void main(String[] args) {
        Kontroll kontroll = new Kontroll();
    }
}
