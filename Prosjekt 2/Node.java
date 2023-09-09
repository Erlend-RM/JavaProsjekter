class Node {
    // har variablenen antallPosessorer og Minnestørrelsen til noden.
    private int antallProsessorer;
    private int minneStorrelse;

    //Konstroktør for Node klassen. Tar inn antall prosessorer og minne. 
    public Node(int antPros, int minne) {
        antallProsessorer = antPros;
        minneStorrelse = minne;
    }

    //Returnerer antall prosessorer i en node.
    public int hentAntPros() {
        return antallProsessorer;
    }

    //Henter minne til noden her.
    public int hentMinne() {
        return minneStorrelse;
    }
    
    //Sjekker om nok minne.
    public boolean nokMinne(int paakrevdMinne) {
        return minneStorrelse >= paakrevdMinne;
    }
}
