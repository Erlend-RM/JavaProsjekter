import java.util.*;
import java.io.*;

class SubsekvensRegister {

    //Beholder for hashmapenen som blir lagt inn i subsekvensregisteret
    ArrayList<HashMap<String,Subsekvens>> hashBeholder = new ArrayList<>();
    
    //Egen hashMap for å slaa sammen hashmapene.
    

    int antallHash = hashBeholder.size();

    //Funksjon for å sette inn hashmapene.
    public void settInnHash(HashMap<String, Subsekvens> hashMapSub){
        hashBeholder.add(hashMapSub);
    }

    //Funksjon for å kunne ta ut hashmapene.
    public HashMap<String, Subsekvens> taUtHash(int pos){
        HashMap<String, Subsekvens> hash = hashBeholder.get(pos);
        return hash;
    }

    //Hente antall
    public int hentAntallHash(){
        return antallHash;
    }

    //Funksjon for å lesefilene.
    public static HashMap<String, Subsekvens> lesFil(String filnavn){
        HashMap<String, Subsekvens> hashMapSub = new HashMap<>();
        try{
            File innLestFil = new File(filnavn);
            Scanner sc = new Scanner(innLestFil);
            String sekvens = "";
            int pos0 = 0;
            int pos1 = 1;
            int pos2 = 2;
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                if(data.length() >= 3) {
                    while (data.length() >= 3) {
                        sekvens += data.charAt(pos0);
                        sekvens += data.charAt(pos1);
                        sekvens += data.charAt(pos2);
                        if (!hashMapSub.containsKey(sekvens)){
                            Subsekvens subsekvens = new Subsekvens(sekvens,1);
                            hashMapSub.put(sekvens, subsekvens);
                        }  
                        sekvens = "";
                        data = data.substring(1);
                    }
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fil ikke funnet.");
            e.printStackTrace();
        }
        return hashMapSub;
    }

    //Funksjon for å flette hashmapene.
    //Denne fuksjonen brukes sammen med SlaaSammenHash fuksjonen.
    public void flett() {
        HashMap<String, Subsekvens> flettet = new HashMap<>();

        for (HashMap<String, Subsekvens> hash : hashBeholder) {
            flettet = slaaSammenHash(flettet, hash);
        }
        hashBeholder.clear();
        hashBeholder.add(flettet);
    }

    //Funksjon for å slaa sammen hashene. Setter inn to hashmaps og
    // sjekker om denne inneholder hashmapene fra den andre.
    //Om de ikke er der fra før settes de inn,
    //om de er der fra før endres tallet.
    public static HashMap<String, Subsekvens> slaaSammenHash(HashMap<String, Subsekvens> hashMapSub, HashMap<String, Subsekvens> hashMapSub2) {
        HashMap<String, Subsekvens> slaattSammenhashMapSub = new HashMap<>();
        slaattSammenhashMapSub.putAll(hashMapSub);
        
        for (String i : hashMapSub2.keySet()){
            if (!slaattSammenhashMapSub.containsKey(i)){
                slaattSammenhashMapSub.put(i, hashMapSub2.get(i));
            }
            else{
                slaattSammenhashMapSub.get(i).endreAntall();
            }
        }
        return slaattSammenhashMapSub;
    }
    
    @Override
    public String toString() {
        String info = "";
        for (HashMap<String, Subsekvens> hash : hashBeholder){
            info += hash;
            info += "\n";
        }
        info += "\n";
        return info;
    }
}
