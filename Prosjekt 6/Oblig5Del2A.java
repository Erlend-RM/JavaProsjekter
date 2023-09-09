import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblig5Del2A {
    
    public static void main(String[] args){
        testdatalitenlike();
        testdatalike();
    }

    //Funksjonen for testdatalitenlike
    //Her leses filene ved bruk av traad
    //og det flettes fortsatt likt som i del 1
    public static void testdatalitenlike() {
        Monitor1 monitor = new Monitor1();
        ArrayList<Thread> traaderSamlet = new ArrayList<>();
        String mappeNavnet = "testdatalitenlike";
        String pathMetadata =  mappeNavnet + "\\/metadata.csv";
        
        File fil = new File(pathMetadata);
        try (Scanner sc = new Scanner(fil)) {
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(",");
                String filnavn = linje[0];
                String pathFil = mappeNavnet+"/"+filnavn;
                LeseTrad leseTrad = new LeseTrad(pathFil,monitor);
                Thread traadLesing = new Thread(leseTrad);
                traaderSamlet.add(traadLesing);
                traadLesing.start();
                
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Feil: Fant ikke fil.");
        }
        try {
            for (Thread traad : traaderSamlet) {
                traad.join();
            }
        }
        catch (InterruptedException e) {
            System.err.println("Feil: klarte ikke joine traader.");
        }
        monitor.flett();
        int hoeyestTall = 0;
        for (Subsekvens sub : monitor.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall < antall) {
                hoeyestTall = antall;
            }
        }
        for (Subsekvens sub : monitor.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall == antall) {
                System.out.println(sub);;
            }
        }
    }

    public static void testdatalike() {
        Monitor1 monitor = new Monitor1();
        ArrayList<Thread> traaderSamlet = new ArrayList<>();
        String mappeNavnet = "testdatalike";
        String pathMetadata =  mappeNavnet + "\\/metadata.csv";
        
        File fil = new File(pathMetadata);
        try (Scanner sc = new Scanner(fil)) {
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(",");
                String filnavn = linje[0];
                String pathFil = mappeNavnet+"/"+filnavn;
                LeseTrad leseTrad = new LeseTrad(pathFil,monitor);
                Thread traadLesing = new Thread(leseTrad);
                traaderSamlet.add(traadLesing);
                traadLesing.start();
                
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Feil: Fant ikke fil.");
        }
        try {
            for (Thread traad : traaderSamlet) {
                traad.join();
            }
        }
        catch (InterruptedException e) {
            System.err.println("Feil: klarte ikke joine traader.");
        }
        monitor.flett();
        int hoeyestTall = 0;
        for (Subsekvens sub : monitor.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall < antall) {
                hoeyestTall = antall;
            }
        }
        for (Subsekvens sub : monitor.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall == antall) {
                System.out.println(sub);;
            }
        }
    }
}
