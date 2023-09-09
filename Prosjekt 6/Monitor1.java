import java.util.*;
import java.util.concurrent.locks.*;


public class Monitor1{

    //Laas for monitoren
    protected Lock laas = new ReentrantLock(true);

    //Komposisjon rundt SubsekvensRegistet
    protected SubsekvensRegister subSekReg = new SubsekvensRegister();
    
    //Her settes inn hashmapene ved bruk av try og finally.
    public void settInnHash(HashMap<String, Subsekvens> hashMapSub) {
        laas.lock();
        try {
            subSekReg.settInnHash(hashMapSub);
        }
        finally {
            laas.unlock();
        }   
    }
    
    public HashMap<String, Subsekvens> taUtHash(int pos){
        laas.lock();
        HashMap<String, Subsekvens> hash = new HashMap<>();
        try {
            hash = subSekReg.taUtHash(pos);
        }
        finally {
            laas.unlock();
        }
        return hash;
    }

    public int hentAntallHash(){
        laas.lock();
        int antall;
        try {
            antall = subSekReg.hentAntallHash();
        }
        finally {
            laas.unlock();
        }
        return antall;
    }

    public void flett() {
        subSekReg.flett();
    }
    
    @Override
    public String toString() {
        String info = "";
        for (HashMap<String, Subsekvens> hash : subSekReg.hashBeholder){
            info += hash;
            info += "\n";
        }
        info += "\n";
        return info;
    }
}
