import java.util.*;
import java.io.*;

public class LesInnFraFil {
    
    public static void main(String[] args) {
        String filNavn = "dataklynge.txt";
        try {
            File minFil = new File(filNavn);
            Scanner sc = new Scanner(minFil);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] tall = data.split(" ");
                System.out.println(data);
                for (String i : tall){ 
                    System.out.println(i);
                    int k = Integer.parseInt(i);
                    System.out.println(k);
                }
        }
            sc.close();
            }
        catch (FileNotFoundException feil) {
            System.out.println("Error: Fant ikke filen " + filNavn);
            feil.printStackTrace();
        }
    }
}
