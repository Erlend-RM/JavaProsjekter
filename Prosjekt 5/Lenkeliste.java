import java.util.Iterator;

abstract class Lenkeliste<T> implements Liste<T> {
    protected Node start;
    int antall = 0;

    //Overrider stoerrelse fra Liste
    //og returnern antallet i listen
    @Override
    public int stoerrelse() {
        return antall;
    }

    public class LenkelisteIterator implements Iterator<T> {
        private Node temp = start;

        @Override
        public boolean hasNext(){
            return temp != null;
        }

        @Override
        public T next(){
            T nokkel = temp.data;
            temp = temp.neste;
            return nokkel;
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }

    //Overrider leggtill fra Liste
    //Denne funksjonen legger til node i lenkelisten
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        nyNode.neste = null;
        if(start == null) {
            start = nyNode;
        }
        else {
            Node temp = start;
            while (temp.neste != null) {
                temp = temp.neste;
            }
            temp.neste = nyNode;
        }
        antall ++;
    }

    //Henter data til node
    @Override
    public T hent() {
        Node node = start;
        return node.data;
    }

    //Fjerner første elementet i listen og returnerer dette
    @Override
    public T fjern() throws UgyldigListeindeks{
        antall --;
        if (start == null) {
            throw new UgyldigListeindeks(0);
        }
        Node node = start;
        if (start != null){
            start = start.neste;
            return node.data;
        }
        return null;
    }

    public void fjernDuplikater(){
        Node denne = start;

        while (denne != null){
            Node temp = denne;
            while (temp != null && temp.data == denne.data){
                temp = temp.neste;
            }
            denne.neste = temp;
            denne = denne.neste;
        }
    }

    public void sorterListe(){

    }



    //Denne funksjonen gir ut tekst fra
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

    //Her blir klassen node opprettet
    public class Node {
        Node neste = null;
        T data;
        public Node(T x) {
            data = x;
        }
    }
}
