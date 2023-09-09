import java.util.*;

public class LeseTrad implements Runnable{
    String filnavn;
    Monitor1 monitor;

    LeseTrad (String filnavn, Monitor1 monitor){
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    //Run metoden for lesetrad.
    //Tar å setter inn hashmapenen i Monitor1
    @Override
    public void run() {
        HashMap<String, Subsekvens> filHashMap = SubsekvensRegister.lesFil(filnavn);
        monitor.settInnHash(filHashMap);
    }
}
