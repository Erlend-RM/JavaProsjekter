class IndeksertListe<T> extends Lenkeliste<T> {

    //her blir objektet lagt til i indeksertliste
    //Det velges hvilken posisjon man skal legge til objektet
    //og man velger hvilket objekt man skal legge til.
    public void leggTil(int pos, T x) {
        Node nyNode = new Node(x);
        Node node = start;
        int indeks = 0;
        
        if (pos == stoerrelse()) {
            leggTil(x);
        }
        else if (pos == 0) {
            nyNode.neste = start;
            start = nyNode;
            antall ++;
        }
        else if (0 < pos && pos < stoerrelse()) {
            while (indeks != pos - 1) {
                node = node.neste;
                indeks ++;
            }
            Node nesteNode = node.neste;
            nyNode.neste = nesteNode;
            node.neste = nyNode;
            antall ++;
        }
        else {
            throw new UgyldigListeindeks(pos);
        }
    }

    //Denne funksjonen tar å erstatter elementet i 
    //den posisjone man selv velger.
    public void sett(int pos, T x) {
        Node nyNode = new Node(x);
        int teller = 0;
        Node node = start;

        if (pos == 0) {
            nyNode.neste = node.neste;
            start = nyNode;
        }
        else if (0 < pos && pos < stoerrelse()) {
            while (teller != pos - 1) {
                node = node.neste;
                teller ++;
            }
            Node forrige = node;
            node = node.neste;
            nyNode.neste = node.neste;
            forrige.neste = nyNode;
        }
        else {
            throw new UgyldigListeindeks(pos);
        }
    }

    //Denne funksjonen tar å henter dataen til noden
    //utifra posisjonen man velger.
    public T hent(int pos) {
        int indeks = 0;
        Node node = start;
        
        if (0 > pos || pos >= stoerrelse()) {
            return node.data;
        }

        while (node != null) {
            if (indeks == pos) {
                return node.data;
            }
            indeks ++;
            node = node.neste;
        }

        return null;
    }

    //Denne funksjonen tar å fjerner en node 
    //utifra den posisjonen man selv velger
    public T fjern(int pos) {
        int indeks = 0;
        Node node = start;

        if (pos == 0) {
            return fjern();
        }
        else if (0 <= pos && pos < stoerrelse()) {
            while (indeks != pos - 1) {
                node = node.neste;
                indeks ++;
            }
            Node forrige = node;
            node = node.neste;
            forrige.neste = node.neste;
            antall --;
            return node.data;
        }
        else {
            throw new UgyldigListeindeks(pos);
        }
    }

    //Tar å overrider toString funksjonen fra lenkeliste
    @Override
    public String toString() {
        String tekst = "";
        Node temp = start;
        while (temp != null) {
            tekst += temp.data + "\n";
            temp = temp.neste;
        }
        return tekst + "null";
    }
}
