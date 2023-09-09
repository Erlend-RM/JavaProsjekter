public class TestLegemiddel {
    public static void main(String[] args) {
        Narkotisk dop = new Narkotisk("MDMA", 140, 2.5, 3);
        Vanedannende dop1 = new Vanedannende("Heroin", 570, 4.5, 6);
        Vanlig dop2 = new Vanlig("Paracet", 60, 2.5);

        System.out.println(dop.toString() + "\n");
        System.out.println(dop1.toString() + "\n");
        System.out.println(dop2.toString());
        
        //Test av narkotisk
        System.out.println("Test av Narkotisk: ");
        if (testLegemiddelNavn(dop, dop.hentNavn()) == true) {
            System.out.println("Navn var riktig");
        }
        else {
            System.out.println("Feil med navn");
        }

        if (testLegemiddelPris(dop, dop.hentPris()) == true) {
            System.out.println("Pris var riktig");
        }
        else {
            System.out.println("Feil med pris");
        }

        if (testLegemiddelId(dop, dop.hentId()) == true) {
            System.out.println("ID var riktig");
        }
        else {
            System.out.println("Feil med ID");
        }
        
        if (testLegemiddelVrikestoff(dop, dop.hentVrikestoff()) == true) {
            System.out.println("Virkestoffet var riktig");
        }
        else {
            System.out.println("Feil med virkestoff");
        }

        if (testLegemiddelNarkotiskStryke(dop, dop.hentNarkotiskStyrke()) == true) {
            System.out.println("Stryken var riktig");
        }
        else {
            System.out.println("Feil med Stryke");
        }

        //Test av Vanedannende
        System.out.println("\nTest av Vanedannende: ");
        if (testLegemiddelNavn(dop1, dop1.hentNavn()) == true) {
            System.out.println("Navn var riktig");
        }
        else {
            System.out.println("Feil med navn");
        }

        if (testLegemiddelPris(dop1, dop1.hentPris()) == true) {
            System.out.println("Pris var riktig");
        }
        else {
            System.out.println("Feil med pris");
        }

        if (testLegemiddelId(dop1, dop1.hentId()) == true) {
            System.out.println("ID var riktig");
        }
        else {
            System.out.println("Feil med ID");
        }
        
        if (testLegemiddelVrikestoff(dop1, dop1.hentVrikestoff()) == true) {
            System.out.println("Virkestoffet var riktig");
        }
        else {
            System.out.println("Feil med virkestoff");
        }

        if (testLegemiddelVanedannendeStryke(dop1, dop1.hentVanedannendeStyrke()) == true) {
            System.out.println("Stryken var riktig");
        }
        else {
            System.out.println("Feil med Stryke");
        }

        //Test av Vanlig
        System.out.println("\nTest av Vanlig: ");
        if (testLegemiddelNavn(dop2, dop2.hentNavn()) == true) {
            System.out.println("Navn var riktig");
        }
        else {
            System.out.println("Feil med navn");
        }

        if (testLegemiddelPris(dop2, dop2.hentPris()) == true) {
            System.out.println("Pris var riktig");
        }
        else {
            System.out.println("Feil med pris");
        }

        if (testLegemiddelId(dop2, dop2.hentId()) == true) {
            System.out.println("ID var riktig");
        }
        else {
            System.out.println("Feil med ID");
        }
        
        if (testLegemiddelVrikestoff(dop2, dop2.hentVrikestoff()) == true) {
            System.out.println("Virkestoffet var riktig");
        }
        else {
            System.out.println("Feil med virkestoff");
        }


    }
    public static boolean testLegemiddelNavn(Legemiddel legemiddel, String forventetLegemiddelNavn) {
        return legemiddel.hentNavn() == forventetLegemiddelNavn;
    }

    public static boolean testLegemiddelPris(Legemiddel legemiddel, int forventetLegemiddelPris) {
        return legemiddel.hentPris() == forventetLegemiddelPris;
    }
    
    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId) {
        return legemiddel.hentId() == forventetLegemiddelId;
    }

    public static boolean testLegemiddelVrikestoff(Legemiddel legemiddel, double forventetLegemiddelVrikestoff) {
        return legemiddel.hentVrikestoff() == forventetLegemiddelVrikestoff;
    }
    
    public static boolean testLegemiddelVanedannendeStryke(Vanedannende vanedannende, int forventetLegemiddelStyrke) {
        return vanedannende.hentVanedannendeStyrke() == forventetLegemiddelStyrke;
    }

    public static boolean testLegemiddelNarkotiskStryke(Narkotisk narkotisk, int forventetLegemiddelStyrke) {
        return narkotisk.hentNarkotiskStyrke() == forventetLegemiddelStyrke;
    }
}
