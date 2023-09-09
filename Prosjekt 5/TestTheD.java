import java.util.*;

public class TestTheD {
    public static void main(String[] args) throws UlovligUtskrift {
        //legemidler
        Vanlig vanlig = new Vanlig("Vanlig", 3210, 100);
        Narkotisk narkotisk = new Narkotisk("Viagra", 20, 200, 2);
        Vanedannende vanedannende = new Vanedannende("Speed", 30, 300, 3);

        //leger
        Lege lege = new Lege("Nam");
        Spesialist spesialist = new Spesialist("Viet", "id123");

        //pasient
        Pasient pasient = new Pasient("Karl", "12345612345");

        //resepter
        HvitResept hvitResept = new HvitResept(vanlig, lege, pasient, 4);
        MilResept militaerresept = new MilResept(narkotisk, spesialist, pasient);
        PResepter pResept = new PResepter(vanlig, lege, pasient, 2);
        BlaaResept blaaResept = new BlaaResept(vanedannende, spesialist, pasient, 10);

        //tester comparable
        System.out.println("tester comparable");
        System.out.println(lege.compareTo(spesialist));
        System.out.println(spesialist.compareTo(lege));
        System.out.println(lege.compareTo(lege));

        System.out.println();

        Lege[] leger = {spesialist, lege};
        System.out.println(leger[0]);
        System.out.println(leger[1]);
        Arrays.sort(leger);
        System.out.println(leger[0]);
        System.out.println(leger[1]);

        System.out.println();

        //tester skrivResept
        System.out.println("\ntester skrivResept");

        HvitResept hvitResept2 = lege.skrivHvitResept(vanlig, pasient, 6);
        lege.skrivHvitResept(vanlig, pasient, 1);
        System.out.println("hvitResept2:");
        System.out.println(hvitResept2);

        System.out.println();

        BlaaResept blaaResept2 = spesialist.skrivBlaaResept(narkotisk, pasient, 3);
        spesialist.skrivBlaaResept(narkotisk, pasient, 3);
        System.out.println("blaaResept2");
        System.out.println(blaaResept2);

        System.out.println();

        System.out.println("listen med resepter");
        System.out.println(spesialist.hentResept());
        //D funker! :)
    }
}

