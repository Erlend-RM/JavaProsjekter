class Subsekvens {
    final String subsekvens;
    private int antallSubsevenser;

    //Konstuktoer for Subsekvnesklassen
    public Subsekvens(String subsekvens, int antallSubsevenser){
        this.subsekvens = subsekvens;
        this.antallSubsevenser = antallSubsevenser;
    }
    
    //Funksjon for hente antallet med subsekvenser
    public int hentAntall(){
        return antallSubsevenser;
    }

    //Funksjon for å kunne endre antallet av subsekvenser
    public void endreAntall(){
        antallSubsevenser ++;
    }

    //Tostring for å kunne gi ut info om subsekvenser
    @Override
    public String toString() {
        return subsekvens + "," + antallSubsevenser;
    }
}