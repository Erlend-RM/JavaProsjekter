public class Lege implements Comparable<Lege>{
    String navn;
    // int indeks = 0;
    int antallResept = 0;
    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    @Override
    public int compareTo(Lege annen){
        return this.navn.compareTo(annen.navn);
    }

    public IndeksertListe<Resept> hentResept(){
        return utskrevneResepter;
    }

    public int antallResept(){
        antallResept++;
        return antallResept;
    }


    public Lege(String navn){
        this.navn = navn;
    }

    // Lager metode for å sjekke om det er narkotisk
    /*private void sjekkNarkotisk(Lege l, Legemiddel lm) throws UlovligUtskrift {
        if ((lm instanceof Narkotisk) && !(l instanceof Spesialist)){
            throw new UlovligUtskrift(l, lm);
        }
    }*/


    // Metoder for å lage resepter
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);}
        HvitResept nyHvitResept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(nyHvitResept);
        // pasient.leggTil(nyHvitResept);
        return nyHvitResept;
    }

    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);}
        MilResept nyMilResept = new MilResept(legemiddel, this, pasient);
        utskrevneResepter.leggTil(nyMilResept);
        return nyMilResept;
    }

    public PResepter skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);}
        PResepter nyPResept = new PResepter(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(nyPResept);
        return nyPResept;
    }

    public BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        if ((legemiddel instanceof Narkotisk) && !(this instanceof Spesialist)){
            throw new UlovligUtskrift(this, legemiddel);}
        BlaaResept nyBlaaResept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(nyBlaaResept);
        return nyBlaaResept;
    }

    @Override
    public String toString(){
        return "Navn på lege: " + navn;
    }

    public String hentLege(){
        return navn;
    }
}
