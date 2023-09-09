import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

public class Modell {
    private GUI gui;
    private Kontroll kontroll;
    private int poeng = 0;
    private int antallEpler = 0;
    private int slangeRad, slangeKol;
    private LinkedList<JLabel> slange = new LinkedList<>();
    

    Modell (GUI gui, Kontroll kontroll) {
        this.gui = gui;
        this.kontroll = kontroll;
    }

    void oekPoeng() {
        poeng++;                
        antallEpler--;
        gui.visPoeng(poeng);
        plasserEpler();
    }

    void nullStillPoeng() {
        poeng = 0;
        gui.visPoeng(poeng);
        Kontroll kontroll = new Kontroll();
    }

    void settStartSlange() {
        int slangeRadStart = 6;
        int slangeKolStart = 6;
        slangeRad = slangeRadStart;
        slangeKol = slangeKolStart;
        JLabel hode = gui.hentRute(slangeRadStart, slangeKolStart);
        slange.add(hode);
    }

    void skrivUtSlange() {
        for (JLabel del : slange) {
            gui.markerSlange(del);
        }
    }

    private boolean gyldigPos(int rad, int kol) {
        if (rad < 0 || rad >= 12) {
            return false;
        }
        if (kol < 0 || kol >= 12) {
            return false;
        }
        if (gui.hentRute(rad, kol).getText().equals("Z")) {
            return false;
        }
        return true;
    }
    
    void flytt(Rettning rettning) {
        int nySlangeRad = slangeRad;
        int nySlangeKol = slangeKol;
        JLabel gammelRute = gui.hentRute(nySlangeRad, nySlangeKol);

        if (Rettning.OPP == rettning) {
            nySlangeRad--;
        }
        if (Rettning.NED == rettning) {
            nySlangeRad++;
        }
        if (Rettning.HOEYRE == rettning) {
            nySlangeKol++;
        }
        if (Rettning.VENSTRE == rettning) {
            nySlangeKol--;
        }

        if(gyldigPos(nySlangeRad, nySlangeKol)) {
            JLabel rute = gui.hentRute(nySlangeRad, nySlangeKol);
            String innholdRute = rute.getText();
            rute.setText("8");
            rute.setBackground(Color.GREEN);
            rute.setForeground(Color.RED);
            slange.add(rute);
            slangeRad = nySlangeRad;
            slangeKol = nySlangeKol;
            gammelRute.setText("Z");
            if(!innholdRute.equals("$")) {
                JLabel hale = slange.remove();
                hale.setText("");
                hale.setBackground(Color.WHITE);
            }
            else {
                oekPoeng();
            }
        }
        else {
            for (int r = 0 ; r < 12 ; r++) {
                for (int k = 0 ; k < 12 ; k++){
                    JLabel rute = gui.hentRute(r, k);
                    if (!(rute.getText().equals("8")) || rute.getText().equals("Z")){
                        rute.setBackground(Color.BLACK);
                        rute.setText("");
                    }
                }
            }
            tap();
        }
    }

    void plasserEpler() {
        Random r = new Random();
        int epleRad = r.nextInt(12);
        int epleKol = r.nextInt(12);
        while(antallEpler <= 10) {
            if(antallEpler == 0) {
                for (int i = 0; i < 10; i++){
                    gui.markerEple(epleRad, epleKol);
                    epleRad = r.nextInt(12);
                    epleKol = r.nextInt(12);
                    antallEpler++;
                }
            }
            else {
                gui.markerEple(epleRad, epleKol);
                epleRad = r.nextInt(12);
                epleKol = r.nextInt(12);
                antallEpler++;
            } 
        }
    }

    void tap() {
        kontroll.tap = true;
    }
}
