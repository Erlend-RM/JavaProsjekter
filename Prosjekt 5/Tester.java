public class Tester {
    public static void main(String[] args){
        // Lager tre virkestoffer
        Narkotisk narkotisk = new Narkotisk("molly", 69, 200, 99);
        Vanlig vanlig = new Vanlig("paracet", 20, 10);
        Vanedannende vanedannende = new Vanedannende("alkohol", 10, 200, 60);

        // Lager leger
        Lege lege = new Lege("dr.Vilfred");
        Spesialist spesialist = new Spesialist("Dr.Ass", "1337");

        // Lager pasienter
        Pasient pasient = new Pasient("Nam", "010169");

        // Lager resepter
        HvitResept hvitResept = new HvitResept(narkotisk, lege, pasient, 3);
        MilResept milresept = new MilResept(narkotisk,lege, pasient);
        PResepter pResepter = new PResepter(narkotisk, lege, pasient, 4);
        BlaaResept blaaResept = new BlaaResept(vanlig, spesialist, pasient, 1);

        IndeksertListe<Resept> lenkeliste = new IndeksertListe<>();
        lenkeliste.leggTil(hvitResept);
        lenkeliste.leggTil(milresept);
        lenkeliste.leggTil(pResepter);
        lenkeliste.leggTil(blaaResept);

        for (Resept resept : lenkeliste){
            System.out.println(resept);
        }

    }
}
