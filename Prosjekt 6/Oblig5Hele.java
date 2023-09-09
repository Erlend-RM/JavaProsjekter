import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Oblig5Hele {
    
    public static void main(String[] args) {
       testdata();
    }

    public static void testdata() {
        Monitor2 frisk = new Monitor2();
        Monitor2 hattVirus = new Monitor2();
       
        ArrayList<Thread> traaderSamletFrisk = new ArrayList<>();
        ArrayList<Thread> traaderSamletHattVirus = new ArrayList<>();

        frisk.aktivLesing = true;
        hattVirus.aktivLesing = true;

        FletteTrad fletteTradFrisk = new FletteTrad(frisk);
        Thread traadFlettingFrisk = new Thread(fletteTradFrisk);
        traadFlettingFrisk.start();

        FletteTrad fletteTradHattVirus = new FletteTrad(hattVirus);
        Thread traadFlettingHattVirus = new Thread(fletteTradHattVirus);
        traadFlettingHattVirus.start();

        String mappeNavnet = "data";
        String pathMetadata =  mappeNavnet + "\\/metadata.csv";
            
        File fil = new File(pathMetadata);
        
        try (Scanner sc = new Scanner(fil);) {
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(",");
                String filnavn = linje[0];
                String sykdomsStatus = linje[1];
                String pathFil = mappeNavnet+"/"+filnavn;
    
                if (sykdomsStatus.equals("True")) {
                    LeseTrad leseTradHattVirus = new LeseTrad(pathFil, hattVirus);
                    Thread traadLesingHattVirus = new Thread(leseTradHattVirus);
                    traaderSamletHattVirus.add(traadLesingHattVirus);
                    traadLesingHattVirus.start();
                }
                else {
                    LeseTrad leseTradFrisk = new LeseTrad(pathFil, frisk);
                    Thread traadLesingFrisk = new Thread(leseTradFrisk);
                    traaderSamletFrisk.add(traadLesingFrisk);
                    traadLesingFrisk.start();
                }  
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Feil: klarte ikke finne Filen.");
        }
        try {
            for (Thread traad : traaderSamletFrisk) {
                traad.join();
            }
            frisk.ferdigMedFletting();
            traadFlettingFrisk.join();
        }
        catch (InterruptedException e) {
            System.err.println("Feil: klarte ikke joine traader.");
        }
        try {
            for (Thread traad : traaderSamletHattVirus) {
                traad.join();
            }
            hattVirus.ferdigMedFletting();
            traadFlettingHattVirus.join();
        }
        catch (InterruptedException e) {
            System.err.println("Feil: klarte ikke joine traader.");
        }
        
        ArrayList<Subsekvens> dominanteSubsekvens = new ArrayList<>();
    
        for (String subsekvens : frisk.subSekReg.taUtHash(0).keySet()) {
            if (hattVirus.subSekReg.taUtHash(0).containsKey(subsekvens)) {  
                if (frisk.subSekReg.taUtHash(0).get(subsekvens).hentAntall() < hattVirus.subSekReg.taUtHash(0).get(subsekvens).hentAntall()) {
                    dominanteSubsekvens.add(hattVirus.subSekReg.taUtHash(0).get(subsekvens));
                }
            }
        }
        System.out.println("De mest dominate subsekvensene hos folk som har hatt virus er:");
    

        for (Subsekvens subsek : dominanteSubsekvens) {
            System.out.println(subsek);
        }
    }
}