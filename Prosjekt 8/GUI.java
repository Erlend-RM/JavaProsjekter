import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    private Kontroll kontroll;
    private JFrame vindu;
    private JPanel panelKnapper, panelAvslutt, panelPoeng, toppPanel,panelRutenett;
    private JButton opp, ned, hoeyre, venstre, avsluttKnapp, nullStill, oekPoeng;
    private JLabel poeng;
    private JLabel[][] ruter = new JLabel[12][12];

    GUI (Kontroll kontroll) {
        this.kontroll = kontroll;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
            System.exit(1);
        }

        vindu = new JFrame("SlangeSpillet");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toppPanel = new JPanel();
        panelKnapper = new JPanel();
        panelAvslutt = new JPanel();
        panelPoeng = new JPanel();
        panelRutenett = new JPanel();

        toppPanel.setLayout(new BorderLayout());
        toppPanel.add(panelKnapper, BorderLayout.CENTER);
        toppPanel.add(panelAvslutt, BorderLayout.EAST);
        toppPanel.add(panelPoeng, BorderLayout.WEST);
        
        vindu.add(toppPanel, BorderLayout.NORTH);
        vindu.add(panelRutenett, BorderLayout.CENTER);
    
        panelKnapper.setLayout(new BorderLayout());
        opp = new JButton("Opp");
        panelKnapper.add(opp, BorderLayout.NORTH);
        ned = new JButton("Ned");
        panelKnapper.add(ned, BorderLayout.SOUTH);
        hoeyre = new JButton("Hoeyre");
        panelKnapper.add(hoeyre, BorderLayout.EAST);
        venstre = new JButton("Venstre");
        panelKnapper.add(venstre, BorderLayout.WEST);

        class BevegOpp implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.settRettning(Rettning.OPP);
            }
        }
        opp.addActionListener(new BevegOpp());

        class BevegNed implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.settRettning(Rettning.NED);
            }
        }
        ned.addActionListener(new BevegNed());
        
        class BevegHoeyre implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.settRettning(Rettning.HOEYRE);
            }
        }
        hoeyre.addActionListener(new BevegHoeyre());

        class BevegVenstre implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.settRettning(Rettning.VENSTRE);
            }
        }
        venstre.addActionListener(new BevegVenstre());
        
        avsluttKnapp = new JButton("Avslutt");
        class Stopper implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.avslutt();;
            }
        }
        avsluttKnapp.addActionListener(new Stopper());

        nullStill = new JButton("Restart");
        class Nuller implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.nullStillPoeng();
            }
        }
        nullStill.addActionListener(new Nuller());

        panelAvslutt.setLayout(new BorderLayout());
        panelAvslutt.add(avsluttKnapp, BorderLayout.CENTER);
        panelAvslutt.add(nullStill, BorderLayout.SOUTH);

        poeng = new JLabel("Lengde: 0 ");
    
        panelPoeng.setLayout(new BorderLayout());
        panelPoeng.add(poeng, BorderLayout.CENTER);

        panelRutenett.setLayout(new GridLayout(12,12));
        for (int rad = 0 ; rad < 12 ; rad++) {
            for (int kol = 0 ; kol < 12 ; kol++) {
                JLabel b = new JLabel(" ");
                ruter[rad][kol] = b;
                b.setOpaque(true);
                b.setBackground(Color.WHITE);
                b.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelRutenett.add(b);
            }
        }
        vindu.pack();
        vindu.setVisible(true);
    }

    void markerSlange(JLabel rute) {
        rute.setText(" 8");
        rute.setBackground(Color.GREEN);
        rute.setForeground(Color.RED);
    }

    void markerEple(int rad, int kol) {
        JLabel rute = ruter[rad][kol];
        rute.setBackground(Color.RED);
        rute.setText("$");
        rute.setForeground(Color.WHITE);
    }

    JLabel hentRute(int rad, int kol) {
        JLabel rute = ruter[rad][kol];
        return rute;
    }

    void visPoeng(int t) {
        poeng.setText("Lengde: " + t + " ");
    } 
}