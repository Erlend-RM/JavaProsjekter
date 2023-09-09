class TestResepter {
    public static void main(String[] args) {
        BlaaResept blaa = new BlaaResept(new Vanlig("Penicillin", 150, 1.2), new Lege("Tor Torsen"), 1337, 5);

        HvitResept hvit = new HvitResept(new Vanlig("Penicillin", 150, 1.2), new Lege("Tor Torsen"), 1337, 5);
        HvitResept mil = new MilResept(new Vanlig("Penicillin", 150, 1.2), new Lege("Tor Torsen"), 1337, 5);
        HvitResept pR = new PResepter(new Vanlig("Penicillin", 150, 1.2), new Lege("Tor Torsen"), 1337, 5);

        System.out.println(blaa.toString() + "\n");
        System.out.println(hvit.toString() + "\n");
        System.out.println(mil.toString() + "\n");
        System.out.println(pR.toString());

        System.out.println("\nPris blaa: " + blaa.prisAaBetale());
        System.out.println("Pris hvit: " + hvit.prisAaBetale());
        System.out.println("Pris Mil: " + mil.prisAaBetale());
        System.out.println("Pris pR: " + pR.prisAaBetale());
    }
}
