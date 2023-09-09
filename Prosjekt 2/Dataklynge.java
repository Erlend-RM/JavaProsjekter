//importerer util for Scanner og Arraylist
import java.util.*;
//importerer io for File og FileNotFoundException
import java.io.*;

class Dataklynge{
    
    //Lager en arraylist for dataklyngen for å ha rankene i
    private ArrayList<Rack> rackArrayList = new ArrayList<>();
    // bruker denne for å sette verdien på å sette maks antall rack
    public int antallPlasserRack;
   

    //Konstroktør for Dataklynge klassen.
    //Tar inn noder filnavn
    //Itterer gjennom filen og lager noder som blir 
    //plassert i racks.
    //Har også try og catch om det skulle være feil med filen
    public Dataklynge(String filnavn){
        try {
            File fil = new File(filnavn);
            Scanner sc = new Scanner(fil);
            String[] tall;
            antallPlasserRack = 12;
            while (sc.hasNextLine()) {
                tall = sc.nextLine().split(" ");
                int antallNoder = Integer.parseInt(tall[0]);
                int antPros = Integer.parseInt(tall[1]);
                int minne = Integer.parseInt(tall[2]);
                Node node = new Node(antPros, minne);
                this.settInnNode(node, antallNoder);
            }
            sc.close();
        }
        catch (FileNotFoundException feil) {
            System.out.println("Error: Fant ikke filen " + filnavn);
            feil.printStackTrace();
            }     
    }
    

    //Bruker denne fuksjonen til å legge til rack i Arraylisten
    public void lagerEtRack(Rack rack) {
        rackArrayList.add(rack);
    }

    //Her hentes arraylisten
    public ArrayList<Rack> hentRackArrayList() {
        return rackArrayList;
    }

    //Setter inn node i rack i dataklyngen
    public void settInnNode(Node node, int antallNoder) {
        if (rackArrayList.size() == 0){
            lagerEtRack(new Rack(antallPlasserRack));
        }
        Rack rack; 
        for (int i = 0; i < antallNoder ; i++) {
            rack = rackArrayList.get(rackArrayList.size()-1);
            if (rack.fultRack()) {
                lagerEtRack(new Rack(antallPlasserRack));
                rack.settInn(node, 0);
            }
            else {
                rack.settInn(node, rack.ledigPlass());
            }
        }
    }

    //Returnerer totalt antall prosessorer i en dataklynge
    public int antProsessorer() {
        int totAntProsData = 0;
        for (Rack rack : rackArrayList){
            totAntProsData += rack.totAntallProsRack();
        }
        return  totAntProsData;
    }

    //Returnerer antall noder med nok minne.
    public int antallNoderMedNokMinne(int paakrevedMinne) {
        int antallMedNokM = 0;
        for (Rack rack : rackArrayList){
            antallMedNokM += rack.noderMedNokMinne(paakrevedMinne);
        }
        return antallMedNokM;
    }

    //Returnerer antall racks i dataklyngen 
    public int antRacks() {
        return rackArrayList.size();
    }
}