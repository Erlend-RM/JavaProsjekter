import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Legesystem {
    LesFil fil = new LesFil("litenEksempelfil.txt");

    IndeksertListe<Pasient> pasientListe = fil.hentPasientliste();
    Prioritetskoe<Lege> legeListe = fil.hentLegeListe();
    IndeksertListe<Legemiddel> legemiddelListe = fil.hentLegemiddelListe();
    IndeksertListe<Resept> reseptListe = fil.hentReseptListe();


    public void skrivUtAlleElementer() {
        System.out.println("ALLE PASIENTER");
        System.out.println(pasientListe);
        System.out.println();
        System.out.println("ALLE LEGER");
        System.out.println(legeListe);
        System.out.println();
        System.out.println("ALLE LEGEMILDER");
        System.out.println(legemiddelListe);
        System.out.println();
        System.out.println("ALLE RESEPTER");
        System.out.println(reseptListe);
        System.out.println();
    }

    public Lege opprettLege() {
        Scanner sc = new Scanner(System.in);
        String kommando;
        System.out.println("1: Vanlig lege \n2: Spesialist");
        kommando = sc.nextLine();
        if (Objects.equals(kommando, "1")) {
            System.out.println("Skriv inn navn på lege: ");
            kommando = sc.nextLine();
            Lege lege = new Lege(kommando);
            LesFil.legeListe.leggTil(lege);
            return lege;
        } else if (Objects.equals(kommando, "2")) {
            System.out.println("Skriv inn navn på spesialist: ");
            String navn;
            navn = sc.nextLine();
            System.out.println("Skriv inn kontrollID på spesialist: ");
            String kontrollID;
            kontrollID = sc.nextLine();
            Spesialist spesialist = new Spesialist(navn, kontrollID);
            LesFil.legeListe.leggTil(spesialist);
            return (spesialist);
        } else {
            System.out.println("Feil input, prøv igjen: ");
        }
        return null;
    }

    public Pasient opprettPasient() {
        Scanner sc = new Scanner(System.in);
        String kommando;
        System.out.println("Skriv inn navn paa pasient: ");
        String navn;
        navn = sc.nextLine();
        System.out.println("Skriv inn foedselsNr paa pasient: ");
        String foedselsNr;
        foedselsNr = sc.nextLine();
        Pasient pasient = new Pasient(navn, foedselsNr);
        LesFil.pasientListe.leggTil(pasient);
        return pasient;
    }

    public Legemiddel opprettLegemiddel() {
        Scanner sc = new Scanner(System.in);
        String kommando;
        System.out.println("Hva slags legemiddel vil du legge inn? \n1: Narkotisk \n2: Vanedannende \n3: Vanlig");
        kommando = sc.nextLine();

        if (Objects.equals(kommando, "1")) {
            System.out.println("Hva er navnet paa det narkotiske legemiddelet:");
            String navn;
            navn = sc.nextLine();
            System.out.println("Tast inn pris: ");
            int pris = Integer.parseInt(sc.nextLine());
            System.out.println("Tast inn virkestoff");
            double virkestoff = Double.parseDouble(sc.nextLine());
            System.out.println("Tast inn styrke: ");
            int styrke = Integer.parseInt(sc.nextLine());
            Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
            LesFil.legemiddelListe.leggTil(narkotisk);
            return narkotisk;

        } else if (Objects.equals(kommando, "2")) {
            System.out.println("Hva er navnet paa det vanedannende legemiddelet:");
            String navn;
            navn = sc.nextLine();
            System.out.println("Tast inn pris: ");
            int pris = Integer.parseInt(sc.nextLine());
            System.out.println("Tast inn virkestoff");
            double virkestoff = Double.parseDouble(sc.nextLine());
            System.out.println("Tast inn styrke: ");
            int styrke = Integer.parseInt(sc.nextLine());
            Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
            LesFil.legemiddelListe.leggTil(vanedannende);
            return vanedannende;

        } else if (Objects.equals(kommando, "3")) {
            System.out.println("Hva er navnet paa det vanlige legemiddelet:");
            String navn;
            navn = sc.nextLine();
            System.out.println("Tast inn pris: ");
            int pris = Integer.parseInt(sc.nextLine());
            System.out.println("Tast inn virkestoff");
            double virkestoff = Double.parseDouble(sc.nextLine());
            Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
            LesFil.legemiddelListe.leggTil(vanlig);
            return vanlig;

        } else {
            return null;
        }
    }

    public Resept opprettResept() throws UlovligUtskrift {
        Scanner sc = new Scanner(System.in);
        String kommando;
        System.out.println("Hva heter du? (Bruk “Dr.“ foran navnet ditt. Eks: Dr. Cox)");
        kommando = sc.nextLine();

        // Metode for aa hente riktig lege
        Lege lege = null;
        for (Lege l : legeListe) {
            String navn = l.hentLege();
            if (kommando.compareTo(navn) == 0) {
                lege = l;  // Dette fikser seg det
            } // Vi skal ha en måte her dersom det ikke er en lege i systemet
        }

        System.out.println("Pasienter i systemet: ");
        System.out.println(LesFil.pasientListe);
        System.out.println("Skriv inn ID på pasienten du oensker aa lage en ny resept paa: ");
        int pasientIDTemp = Integer.parseInt(sc.nextLine());

        // Metode for aa hente riktig pasient
        Pasient pasient = null;
        for (Pasient p : pasientListe) {
            int pasientID = p.hentPasientID();

            if (pasientID == pasientIDTemp) {
                pasient = p;
            } // Vi må ha noe dersom pasienten ikke finnes
        }


        System.out.println("Legemidler i systemet: ");
        System.out.println(LesFil.legemiddelListe);
        System.out.println("Skriv inn legemiddel ID paa det du oensker i resepten: ");
        int legemiddelIDTemp = Integer.parseInt(sc.nextLine());

        Legemiddel legemiddel = null;
        for (Legemiddel lm : legemiddelListe) {
            int legemiddelID = lm.hentId();

            if (legemiddelID == legemiddelIDTemp) {
                legemiddel = lm;
            }
        }


        System.out.println("Hva slags resept oensker du aa opprette? \n1: Hvit resept \n2: Blaa resept \n3: Militaer resept \n4: P resept");
        kommando = sc.nextLine();
        if (Objects.equals(kommando, "1")) {
            System.out.println("Hvor mange reit skal det vaere i resepten? ");
            int reit = Integer.parseInt(sc.nextLine());
            HvitResept hvitResept = lege.skrivHvitResept(legemiddel, pasient, reit);
            LesFil.reseptListe.leggTil(hvitResept);
            pasient.leggTil(hvitResept);
            return hvitResept;
        } else if (Objects.equals(kommando, "2")) {
            System.out.println("Hvor mange reit skal det vaere i resepten?");
            int reit = Integer.parseInt(sc.nextLine());
            BlaaResept blaaResept = lege.skrivBlaaResept(legemiddel, pasient, reit);
            LesFil.reseptListe.leggTil(blaaResept);
            pasient.leggTil(blaaResept);
            return blaaResept;
        } else if (Objects.equals(kommando, "3")) {
            MilResept milResept = lege.skrivMilResept(legemiddel, pasient);
            LesFil.reseptListe.leggTil(milResept);
            pasient.leggTil(milResept);
            return milResept;
        } else if (Objects.equals(kommando, "4")) {
            System.out.println("Hvor mange reit skal det vaere i resepten?");
            int reit = Integer.parseInt(sc.nextLine());
            PResepter pResepter = lege.skrivPResept(legemiddel, pasient, reit);
            LesFil.reseptListe.leggTil(pResepter);
            pasient.leggTil(pResepter);
            return pResepter;
        } else {
            System.out.println("Dette ble feil kompis");
        } return null;
    }

    public void brukResept(){
        Scanner sc = new Scanner(System.in);
        String kommando;

        System.out.println("Oversikt over alle pasienter: ");
        System.out.println(LesFil.pasientListe);
        System.out.println("Hvilken pasient vil du se resepter for? (Skriv inn pasient ID)");

        int pasientIDTemp = Integer.parseInt(sc.nextLine());
        // Metode for aa hente pasient
        Pasient pasient = null;
        for (Pasient p : LesFil.pasientListe) {
            int pasientID = p.hentPasientID();

            if (pasientID == pasientIDTemp) {
                pasient = p;
            } // Vi må ha noe dersom pasienten ikke finnes
        }
        System.out.println("Valgt pasient: ");
        System.out.println(pasient);

        System.out.println("Hvilken resept vil du bruke? (Skriv inn resept ID) \n");
        System.out.println(pasient.hentPasientReseptListe());
        int reseptIDTemp = Integer.parseInt(sc.nextLine());

        Resept resept = null;
        for (Resept r : pasient.hentPasientReseptListe()){
            int reseptID = r.hentId();

            if (reseptID == reseptIDTemp) {
                resept = r;
            }
        }
        resept.bruk();
    }

    public void hentStatistikk(){
        Scanner sc = new Scanner(System.in);
        String kommando;

        System.out.println("Skriv ut statistikk for: \n1: Totalt antall utskrevne resepter paa vanedannende legemidler: " +
                "\n2: Totalt antall utskrevne resepter paa narkotiske legemidler \n3: Mulig misbruk av narkotika ");
        kommando = sc.nextLine();
        if (Objects.equals(kommando, "1")){
            int tellVanedannende = 0;
            for (Resept r : LesFil.reseptListe){
                if (r.hentLegemiddel() instanceof Vanedannende){
                    tellVanedannende ++;
                }
            }
            System.out.println();
            System.out.println("Antall vanedannende resepter: "+tellVanedannende);
            System.out.println();
        } else if (Objects.equals(kommando, "2")){
            int tellNarkotisk = 0;
            for (Resept r : LesFil.reseptListe){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    tellNarkotisk ++;
                }
            }
            System.out.println();
            System.out.println("Antall narkotiske resepter: "+tellNarkotisk);
            System.out.println();
        } else if (Objects.equals(kommando, "3")){

            int teller = 0;
            Prioritetskoe<Lege> legerTemp = new Prioritetskoe<>();
            Prioritetskoe<Lege> legerTotalt = new Prioritetskoe<>();
            for (Resept r : LesFil.reseptListe){
                if (r.hentLegemiddel() instanceof Narkotisk){
                    legerTotalt.leggTil(r.hentLege());
                    legerTemp.leggTil(r.hentLege());
                }
            }
            legerTemp.fjernDuplikater();

            for (Lege l : legerTemp){
                teller = 0;
                System.out.println(l);
                for (Lege lg : legerTotalt){
                    if (lg == l){
                        teller++;
                    }
                }
                System.out.print("Antall resept: "+teller+"\n");
            }
            System.out.println();

            int tellerP = 0;
            IndeksertListe<Pasient> pasienterTemp = new IndeksertListe<>();
            IndeksertListe<Pasient> pasienterTotal = new IndeksertListe<>();
            for (Resept r : LesFil.reseptListe) {
                if (r.hentLegemiddel() instanceof Narkotisk) {
                    pasienterTotal.leggTil(r.hentPasient());
                    pasienterTemp.leggTil(r.hentPasient());
                }
            }
            pasienterTemp.fjernDuplikater();

            for (Pasient p : pasienterTemp){
                tellerP = 0;
                System.out.println(p);
                for (Pasient ps : pasienterTotal){
                    if (ps == p){
                        tellerP++;
                    }
                }
                System.out.print("Antall resept: "+tellerP+"\n");
            }
        }
    }

    public void Hovedmeny() throws UlovligUtskrift {

        // Lager en metode for å skrive ut valgmeny i terminalen
        System.out.println("Velkommen til valgmenyen. Velg hva du ønsker å gjøre: ");
        System.out.println("1: Skriv ut fullstendig oversikt over pasienter, leger, legemidler og resepter. \n2: Opprett og legg til nye elementer i systemet. " +
                "\n3: Bruke en gitt resept fra listen til en pasient. \n4: Skrive ut forskjellige former for statistikk. \n5: Skrive ut alle data fra fil. \n6: Avslutt \nVelg din kommando: ");
        Scanner sc = new Scanner(System.in);
        String kommando;
        kommando = sc.nextLine();

        // Vi legger hele dette systemet inn i Legesystem etterpå
        if (Objects.equals(kommando, "1")) {
            skrivUtAlleElementer();
            Hovedmeny();
        } else if (Objects.equals(kommando, "2")) {
            System.out.println("1: Legge til en lege. \n2: Legge til en pasient. " +
                    "\n3: Legge til resept. \n4: Legge til legemiddel. \n5: Tilbake til hovedmeny. \nVelg din kommando: ");
            kommando = sc.nextLine();
            if (Objects.equals(kommando, "1")) {
                opprettLege();
                Hovedmeny();
            } else if (Objects.equals(kommando, "2")) {
                opprettPasient();
                Hovedmeny();
            } else if (Objects.equals(kommando, "3")) {
                opprettResept();
                Hovedmeny();
            } else if (Objects.equals(kommando, "4")) {
                opprettLegemiddel();
                Hovedmeny();
            } else {
                System.out.println("Feil input, prøv igjen");
                Hovedmeny();
            }
        } else if (Objects.equals(kommando, "3")){
            brukResept();
            Hovedmeny();
        } else if (Objects.equals(kommando, "4")) {
            hentStatistikk();
            Hovedmeny();
        } else if (Objects.equals(kommando, "5")) {
            System.out.println("Skriv inn ønsket filnavn: ");
            kommando = sc.nextLine();
            SkrivTilFil(kommando);
            Hovedmeny();
        } else if (Objects.equals(kommando, "6")) {
            System.out.println("Avslutter program");
        } else {
            System.out.println("Feil input, prøv igjen ");
            Hovedmeny();
        }
    }

    public void SkrivTilFil(String filnavn){
        try {
            File nyFil = new File(filnavn);
            if (nyFil.createNewFile()){
                System.out.println("Ny fil lagd. Filnavn: "+nyFil.getName());
            } else {
                System.out.println("Feil: Filen finnes alt på pc. ");
            }
        } catch (IOException e){
            System.out.println("Kan ikke lagre fil.");
            e.printStackTrace();
        }
        try {
            FileWriter nySkrivendeFil = new FileWriter(filnavn);
            nySkrivendeFil.write("# Pasienter (navn, fnr)\n");
            for (Pasient p : pasientListe) {
                nySkrivendeFil.write(p.hentPasientInfo()+"\n");
            }
            nySkrivendeFil.write("# Legemidler (navn, type, pris, virkestoff, [styrke])\n");
            for (Legemiddel l : legemiddelListe){
                if (l instanceof Narkotisk) {
                    nySkrivendeFil.write(l.hentLegemiddelInfo() + "\n");
                } else if (l instanceof Vanedannende){
                    nySkrivendeFil.write(l.hentLegemiddelInfo() + "\n");
                } else {
                    nySkrivendeFil.write(l.hentLegemiddelInfo() + "\n");
                }
            }
            nySkrivendeFil.write("# Leger (navn, kontrollID / 0 hvis vanlig lege)\n");
            for (Lege l : legeListe){
                if (l instanceof Spesialist){
                    nySkrivendeFil.write(l.hentLege()+","+((Spesialist) l).hentKontrollID()+"\n");
                } else {
                    nySkrivendeFil.write(l.hentLege()+",0\n");
                }
            }
            nySkrivendeFil.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for (Resept r : reseptListe){
                int legemiddelNr = r.hentLegemiddel().hentId();
                String legeNavn = r.hentLege().hentLege();
                int pasientID = r.hentPasient().hentPasientID();
                if (r instanceof BlaaResept){
                    String blaaResept = r.hentReseptInfo();
                    nySkrivendeFil.write(legemiddelNr+","+legeNavn+","+pasientID+","+blaaResept+","+r.reit+"\n");
                } else if (r instanceof PResepter){
                    String pResept = r.hentReseptInfo();
                    nySkrivendeFil.write(legemiddelNr+","+legeNavn+","+pasientID+","+pResept+","+r.reit+"\n");
                } else if (r instanceof  MilResept){
                    String milResept = r.hentReseptInfo();
                    nySkrivendeFil.write(legemiddelNr+","+legeNavn+","+pasientID+","+milResept+"\n");
                } else {
                    String hvitResept = r.hentReseptInfo();
                    nySkrivendeFil.write(legemiddelNr+","+legeNavn+","+pasientID+","+hvitResept+","+r.reit+"\n");
                }
            }

            nySkrivendeFil.close();
        } catch (IOException e){
            System.out.println("Feil ved skriving av fil");
            e.printStackTrace();
        }
    }
}