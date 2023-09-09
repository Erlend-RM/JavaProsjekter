class Prioritetskoe <T extends Comparable<T>> extends Lenkeliste<T> {


    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        antall++;
        Node forrige = null;
        Node denne = start;

        while(denne != null && x.compareTo(denne.data) >= 0){
            forrige = denne;
            denne = denne.neste;
        }

        if(forrige == null){
            start = nyNode;
        }else{
            forrige.neste = nyNode;
        }
        nyNode.neste = denne;
    }
}
