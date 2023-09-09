class Spesialist extends Lege implements Godkjenningsfritak {
    
    String kontrollId;

    Spesialist(String legensNavn, String kontrollId) {
        super(legensNavn);
        this.kontrollId = kontrollId;
    }

    @Override
    public String hentKontrollId() {
        return kontrollId;
    }

    @Override
    public String toString() {
        return ("Navn lege: " + legensNavn + "\nKontroll ID: " + kontrollId);
    }
}
