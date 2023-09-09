import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig5Del1 {

    //Main metoden for programmet.
    //Her kjøres metoden for testdatalitenlike og testdatalike.
    //Må ha en mappe med liggende med disse filen 
    //for at programmet skal kjøre som det skal.
    public static void main(String[] args){
        testdatalitenlike();
        testdatalike();
    }

    //Metodene som leser inn fil og finner pathen til filene.
    //setter de inn, fletter og finner ut hvem det er flest
    //forekomster av. Den for testdatalike er lik.
    public static void testdatalitenlike() {
        String mappeNavnet = "testdatalitenlike";
        String pathMetadata =  mappeNavnet + "\\/metadata.csv";
        
        SubsekvensRegister subSekReg = new SubsekvensRegister();
        File fil = new File(pathMetadata);
        try (Scanner sc = new Scanner(fil)) {
            
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(",");
                String filnavn = linje[0];
                String pathFil = mappeNavnet+"/"+filnavn;
                subSekReg.settInnHash(SubsekvensRegister.lesFil(pathFil));
                
            }
            subSekReg.flett();
        }
        catch (FileNotFoundException e) {
            System.err.println("Feil: Fant ikke fil.");
        }
        int hoeyestTall = 0;
        for (Subsekvens sub : subSekReg.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall < antall) {
                hoeyestTall = antall;
            }
        }
        for (Subsekvens sub : subSekReg.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall == antall) {
                System.out.println(sub);;
            }
        }
    }

    public static void testdatalike() {
        String mappeNavnet = "testdatalike";
        String pathMetadata =  mappeNavnet + "\\/metadata.csv";
        
        SubsekvensRegister subSekReg = new SubsekvensRegister();

        File fil = new File(pathMetadata);
        try (Scanner sc = new Scanner(fil)) {
            
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(",");
                String filnavn = linje[0];
                String pathFil = mappeNavnet+"/"+filnavn;
                subSekReg.settInnHash(SubsekvensRegister.lesFil(pathFil));
                
            }
            subSekReg.flett();
        }
        catch (FileNotFoundException e) {
            System.err.println("Feil: Fant ikke fil.");
        }
        int hoeyestTall2 = 0;
        for (Subsekvens sub : subSekReg.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall2 < antall) {
                hoeyestTall2 = antall;
            }
        }
        for (Subsekvens sub : subSekReg.taUtHash(0).values()) {
            int antall = sub.hentAntall();
            if (hoeyestTall2 == antall) {
                System.out.println(sub);
            }
        }
    }
}
