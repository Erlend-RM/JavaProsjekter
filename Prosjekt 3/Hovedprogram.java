class Hovedprogram {
    public static void main(String[] args) {
        Narkotisk mdma = new Narkotisk("MDMA", 250, 3.4, 6);
        Vanedannende morfin = new Vanedannende("Morfin", 160, 2.4, 5);
        Vanlig paracetanol = new Vanlig("Paracetanol", 95, 1.5);
        
        System.out.println(mdma.toString() + "\n"); 
        System.out.println(morfin.toString() + "\n"); 
        System.out.println(paracetanol.toString() + "\n");

        Lege lege1 = new Lege("Svein Storo");
        Spesialist lege2 = new Spesialist("Per Paal", "313");
        
        HvitResept hvitResept = new HvitResept(mdma, lege1, 1337, 2);
        BlaaResept blaaResept = new BlaaResept(morfin, lege2, 420, 5);
        MilResept milResept = new MilResept(paracetanol, lege1, 69, 2);
        PResepter pResepter = new PResepter(paracetanol, lege2, 71, 3);

        System.out.println(hvitResept.toString() + "\n");
        System.out.println(blaaResept.toString() + "\n");
        System.out.println(milResept.toString() + "\n");
        System.out.println(pResepter.toString() + "\n");
    }
}

