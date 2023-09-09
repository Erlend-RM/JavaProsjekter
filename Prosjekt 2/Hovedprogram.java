
class Hovedprogram {
    
    public static void main(String[] args) {
        //lager her dataklyngen
        Dataklynge dataklynge = new Dataklynge("dataklynge2.txt");

        //Skriver ut infoen om dataklyngen her.
        System.out.println("Informasjon om Dataklynge: dataklyng2.txt" );
        System.out.println("Noder med minst 128GB: " + dataklynge.antallNoderMedNokMinne(128));
        System.out.println("Noder med minst 512GB: " + dataklynge.antallNoderMedNokMinne(512));
        System.out.println("Noder med minst 1024GB: " + dataklynge.antallNoderMedNokMinne(1024));
        
        System.out.println("\nAntall Prosessorer: " + dataklynge.antProsessorer());
        System.out.println("Antall Rack: " + dataklynge.antRacks());
    }
}
