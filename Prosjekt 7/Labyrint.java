import java.io.*;
//import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint {
    String filnavn;
    int antallRader;
    int antallKolonner;
    Rute [][] labyrint ;

    Labyrint(String filnavn){
        this.filnavn = filnavn;
        System.out.println("Labyrinten:");
        lesfil(filnavn);
        settNaboer();
    }

    void lesfil(String filnavn) {
        String mappeNavnet = "labyrinter";
        String pathMetadata =  mappeNavnet + "\\" + filnavn;
        if(filnavn.contains(".in")) {
            try {
                File innLestFil = new File(pathMetadata);
                Scanner sc = new Scanner(innLestFil);
                
                //Tar å henter ut antall rader og antall kolonnoer fra første linje
                String[] antallRaderKolonner = sc.nextLine().split(" ");
                antallRader = Integer.parseInt(antallRaderKolonner[0]);
                antallKolonner = Integer.parseInt(antallRaderKolonner[1]);
                
                labyrint = new Rute[antallRader][antallKolonner];
    
                int rad = 0;
                int kolonne = 0;
    
                while (sc.hasNextLine()) {
                    String data = sc.nextLine();
    
                    kolonne = 0;
                    
                    char[] linje = data.toCharArray();
                    for (char tegn : linje) {
                        if (tegn == '#') {
                            SortRute sortRute = new SortRute(rad, kolonne, this);
                            
                            labyrint[rad][kolonne] = sortRute;
                        }
                        else if (tegn == '.') {

                            if ((kolonne == 0 || kolonne == antallKolonner-1)  || (rad == 0 || rad == antallRader-1 )) {
                                Aapning aapning = new Aapning(rad, kolonne, this);

                                labyrint[rad][kolonne] = aapning;
                            }
                            else {
                                HvitRute hvitRute = new HvitRute(rad, kolonne, this);
    
                                labyrint[rad][kolonne] = hvitRute;
                            }
                        }
                        kolonne ++;
                    }
                    rad ++;
                }
                sc.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Fant ikke denne filen.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("feil fil type proev igjen");
            return;
        }
    }

    void settNaboer() {
        for (int rad = 0 ; rad < antallRader ; rad++){
            for (int kolonne = 0 ; kolonne < antallKolonner ; kolonne++){
                Rute rute = labyrint[rad][kolonne];
                if (rad != 0) {
                    rute.settNabo("nord", labyrint[rad - 1][kolonne]);
                }
                if (rad != antallRader-1) {
                    rute.settNabo("syd", labyrint[rad + 1][kolonne]);
                }
                if (kolonne != antallKolonner-1) {
                    rute.settNabo("vest", labyrint[rad][kolonne + 1]);
                }
                if (kolonne != 0) {
                    rute.settNabo("oest", labyrint[rad][kolonne - 1]);
                }
                
                /*Rute ruteNord = labyrint[rad-1][kolonne];
                Rute ruteVest = labyrint[rad][kolonne-1];

                rute.ruteNord = ruteNord;
                rute.ruteVest = ruteVest;

                ruteNord.ruteSyd = rute;
                ruteNord.ruteOest = rute;*/
            }
        }
    }

    void finnUtveiFra(int rad, int kol) {
        Rute startRute = labyrint[rad][kol];
        startRute.finn(null);
    }

    @Override
    public String toString() {
        String antallRaderKolonner = "Antall rader: " + antallRader + "\nAntall konlonner: " + antallKolonner + "\n";
        String linje = "";
        for (Rute[] rad : labyrint) {
            for (Rute rute : rad) {
                linje += rute;
            }
            linje += "\n";
        }
        return antallRaderKolonner + linje;
    }
}