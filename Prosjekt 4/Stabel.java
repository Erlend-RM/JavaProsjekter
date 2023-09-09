class Stabel<T> extends Lenkeliste<T> {

    //Her blir leggtil overridet fra lenkeliste
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        if (antall == 0) {
            start = nyNode;
        }
        else {
            Node node = start;
            start = nyNode;
            start.neste = node;
        }
        antall ++;
    }
}

