
class Rack {
    //Array for å ha nodene i
    private Node[] nodeArray;

    //Konstroktør for Rack klassen
    //Her legger man inn antall noder man skal ha i rack
    public Rack(int antallNoderIRack){
        nodeArray = new Node[antallNoderIRack];
    }

    //Fokusjonene setter inn noder i racket.
    public void settInn(Node node, int plass){
        nodeArray[plass] = node;
    }

    //Returnere totalt antall noder i racket.
    public int antNoder(){
        int antallNoder = nodeArray.length;
        return antallNoder;
    }
    
    //Returnerer Node Arrayen
    public Node[] hentNodeArray(){
        return nodeArray;
    }

    //Sjekker om nodene har nok minne.
    public int noderMedNokMinne(int paakrevMinne) {
        int noderMedNokMinne = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            if ((nodeArray[i] != null) && (nodeArray[i].nokMinne(paakrevMinne))) {
                noderMedNokMinne ++;
            }
        }
        return noderMedNokMinne;
    }

    //Returnerer det totale antallet med prosessorer i racket.
    public int totAntallProsRack() {
        int totAntallPros = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i] != null) {
                totAntallPros += nodeArray[i].hentAntPros();
            }
        }
        return totAntallPros;
    }

    //Sjekker om racket er fult eller ikke for om må lage nytt rack 
    public boolean fultRack() {
        if (nodeArray[nodeArray.length-1] != null) {
            return true;
        }
        return false;
    }

    //Sjekker om ledig plass for node i racket.
    public int ledigPlass() {
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
}
