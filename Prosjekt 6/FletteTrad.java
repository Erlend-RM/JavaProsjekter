public class FletteTrad implements Runnable{
    Monitor2 monitor;

    FletteTrad (Monitor2 monitor){
        this.monitor = monitor;
    }

    //Run metoden for flettetrad. fletter sammen hashmapene.
    //Kjøre om aktivlesing er True eller at monitoren sitt
    //antall av hash er større en 1.
    @Override
    public void run() {
        for (int i = 0; i < 8 ; i++){
            while (monitor.aktivLesing || monitor.hentAntallHash() > 1) {
                monitor.slaaSammenHash();
            }
        }
    }
}
