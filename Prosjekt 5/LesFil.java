import java.io.*;
import java.util.*;

public class LesFil {
    protected static IndeksertListe<Pasient> pasientListe = new IndeksertListe<>();
    protected static IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
    protected static Prioritetskoe<Lege> legeListe = new Prioritetskoe<>();
    protected static IndeksertListe<Resept> reseptListe = new IndeksertListe<>();

    String filnavn;

    public LesFil(String filnavn) {
        this.filnavn = filnavn;

        try {
            File nyttObjekt = new File(this.filnavn);
            Scanner nyScanner = new Scanner(nyttObjekt);
            String gjeldendeObjekt = "";
            int linjeNr = 0;
            while (nyScanner.hasNextLine()) {
                String linje = nyScanner.nextLine();
                linjeNr++;
                String[] hashtag = linje.trim().split(" ");  // Første linje som skiller objekter har mellomrom
                if (Objects.equals(hashtag[0], "#")) {
                    gjeldendeObjekt = hashtag[1]; // Neste element i hashtag vil være det objektet vi skal jobbe med
                    linje = nyScanner.nextLine();
                    linjeNr++;

                    // Metode for aa lage nye Pasientobjekter
                }
                if (Objects.equals(gjeldendeObjekt, "Pasienter")) {
                    String[] pasientLinje = linje.split(",");
                    String navn = pasientLinje[0];
                    String foedselsNr = pasientLinje[1];
                    Pasient pasient = new Pasient(navn, foedselsNr);
                    pasientListe.leggTil(pasient);


                    // Metode for aa lage nye legemiddelobjekter
                } else if (Objects.equals(gjeldendeObjekt, "Legemidler")) {
                    String[] legemiddelLinje = linje.split(",");
                    String navn = legemiddelLinje[0];
                    String type = legemiddelLinje[1];
                    int pris = Integer.parseInt(legemiddelLinje[2]);
                    double virkestoff = Double.parseDouble(legemiddelLinje[3]);


                    if (Objects.equals(type, "narkotisk")) {
                        int styrke = Integer.parseInt(legemiddelLinje[4]);
                        Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                        legemiddelListe.leggTil(narkotisk);
                    } else if (Objects.equals(type, "vanedannende")) {
                        int styrke = Integer.parseInt(legemiddelLinje[4]);
                        Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                        legemiddelListe.leggTil(vanedannende);
                    } else {
                        Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
                        legemiddelListe.leggTil(vanlig);
                    }


                } else if (Objects.equals(gjeldendeObjekt, "Leger")) {
                    String[] legeLinje = linje.split(",");
                    String navn = legeLinje[0];
                    if (!Objects.equals(legeLinje[1], "0")) {
                        String kontrollID = legeLinje[1];
                        Spesialist spesialist = new Spesialist(navn, kontrollID);
                        legeListe.leggTil(spesialist);
                    } else {
                        Lege lege = new Lege(navn);
                        legeListe.leggTil(lege);
                    }
                } else {
                    String[] reseptLinje = linje.split(",");
                    int legemiddelNr = Integer.parseInt(reseptLinje[0]);
                    String legeNavn = reseptLinje[1];
                    int pasientID = Integer.parseInt(reseptLinje[2]);
                    String type = reseptLinje[3];


                    Legemiddel legemiddel = null;
                    Lege lege = null;
                    Pasient pasient = null;
                    if (Objects.equals(type, "militaer")) {
                        for (Legemiddel i : legemiddelListe) {
                            if (i.hentId() == legemiddelNr) {
                                legemiddel = i;
                            }
                        }
                        for (Lege l : legeListe) {
                            if (Objects.equals(l.hentLege(), legeNavn)) {
                                lege = l;
                            }
                        }

                        for (Pasient p : pasientListe) {
                            if (p.hentPasientID() == pasientID) {
                                pasient = p;
                            }
                        }

                        MilResept milResept = new MilResept(legemiddel, lege, pasient);
                        pasient.leggTil(milResept);
                        reseptListe.leggTil(milResept);
                    } else {
                        int reit = Integer.parseInt(reseptLinje[4]);
                        for (Legemiddel i : legemiddelListe) {
                            if (i.hentId() == legemiddelNr) {
                                legemiddel = i;
                            }
                        }
                        for (Lege l : legeListe) {
                            if (Objects.equals(l.hentLege(), legeNavn)) {
                                lege = l;
                            }
                        }

                        for (Pasient p : pasientListe) {
                            if (p.hentPasientID() == pasientID) {
                                pasient = p;
                            }
                        }
                        if (Objects.equals(type, "hvit")) {
                            HvitResept hvitResept = new HvitResept(legemiddel, lege, pasient, reit);
                            reseptListe.leggTil(hvitResept);
                            pasient.leggTil(hvitResept);
                        } else if (Objects.equals(type, "p")) {
                            PResepter pResept = new PResepter(legemiddel, lege, pasient, reit);
                            pasient.leggTil(pResept);
                            reseptListe.leggTil(pResept);
                        } else {
                            BlaaResept blaaResept = new BlaaResept(legemiddel, lege, pasient, reit);
                            reseptListe.leggTil(blaaResept);
                            pasient.leggTil(blaaResept);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen");
            e.printStackTrace();
        }
    }


    public IndeksertListe<Pasient> hentPasientliste(){
        return pasientListe;
    }

    public IndeksertListe<Legemiddel> hentLegemiddelListe(){
        return legemiddelListe;
    }

    public Prioritetskoe<Lege> hentLegeListe(){
        return legeListe;
    }

    public IndeksertListe<Resept> hentReseptListe(){
        return reseptListe;
    }
}
