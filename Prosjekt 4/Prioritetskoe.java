class Prioritetskoe <T extends Comparable<T>> extends Lenkeliste<T> {
    
    //I denne klassen så overrider man leggTil
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);

        if (start == null) {
            start = nyNode;
        }
        else {
            Node node = start;
            int ulik = x.compareTo(node.data);

            if (ulik <= 0) {
                nyNode.neste = start;
                start = nyNode;
            }
            else {
                while (ulik > 0 && node.neste != null) {
                    node = node.neste;
                    ulik = x.compareTo(node.data);
                }

                nyNode.neste = node.neste;
                node.neste = nyNode;
            }
        }
        antall ++;
    }
}
