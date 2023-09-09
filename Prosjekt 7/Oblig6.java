import java.util.Scanner;

public class Oblig6 {
    public static void main(String[] args) {
        String filnavn = args[0];
        Labyrint lab = new Labyrint(filnavn);
        System.out.println(lab);
        Scanner sc = new Scanner(System.in);

        String kordinatenen = "";        
        
        while (!kordinatenen.equals("-1")) {
            
            System.out.println("Skriv inn start kordinatenen (rad) (kolonne).\n('-1' for aa avslutte programmet).");
            
            kordinatenen = sc.nextLine().strip();
            
            if(!kordinatenen.equals("-1") && kordinatenen.contains(" ")) {
                int rad = Character.getNumericValue(kordinatenen.charAt(0));
                int kol = Character.getNumericValue(kordinatenen.charAt(2));
                lab.finnUtveiFra(rad, kol);
            }
            else if (!kordinatenen.equals("-1")) {
                System.out.println("Feil ved innskriving av kordinat proev igjen. eks: 1 1");
            }
        }
        sc.close();   
    }
}
