import java.util.*;
import java.util.concurrent.locks.*;

public class Monitor2 extends Monitor1 {

    //Condition for om hashmapen er flettbar
    public Condition flettbar = laas.newCondition();
    //Aktiv lesing er satt til false i starten
    public Boolean aktivLesing = false;

    //Denne kjører når man er ferdig med fletting
    //og setter aktiv lesing tilbake til false og
    //Gir signal til flettetraaden om at de skal stoppe.
    public void ferdigMedFletting() {
        aktivLesing = false;
        laas.lock();
        try {
            flettbar.signalAll();
        }
        finally {
            laas.unlock();
        }
    }

    @Override
    public void settInnHash(HashMap<String, Subsekvens> hashMapSub) {
        laas.lock();
        try {
            subSekReg.settInnHash(hashMapSub);
            if (subSekReg.hentAntallHash() >= 2){
                flettbar.signal();
            }
        }
        finally {
            laas.unlock();
        }   
    }
    
    public void slaaSammenHash() {
        laas.lock();

        try {
            if (hentAntallHash() < 2) {
                flettbar.await();
            }
            flett();
        }
        catch (InterruptedException e) {
            System.err.println("Feil: Klarte ikke flette.");
            System.exit(1);
        }
        finally {
            laas.unlock();
        }
    }


}
