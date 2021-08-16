public class LinkedListDeque<Stuff> {
    public class StuffNode {
        public StuffNode prev;
        public Stuff item;
        public StuffNode next;
        public StuffNode(StuffNode p, Stuff i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode item;
    private int sizeConstant;
    public StuffNode sentinel;

    public LinkedListDeque(Stuff x){
        sentinel = new StuffNode(null, x, null);
        item = new StuffNode(sentinel, x, null);
        sentinel.prev = item;
        sentinel.next = item;
        sizeConstant = 1;
    }

    private void connectNodes(StuffNode a, StuffNode b) {
        a.next = b;
        b.prev = a;
    }

    private void disConnectNodes(StuffNode a, StuffNode b) {
        a.next = null;
        b.prev = null;
    }

    public LinkedListDeque() {
        item = null;
        sentinel = null;
        sizeConstant = 0;
    }


    public void addFirst(Stuff f) {
        sizeConstant += 1;
        if (sentinel == null) {
            StuffNode newNode = new StuffNode(null, f, null);
            sentinel = new StuffNode(newNode, f, newNode);
            return;
        }
        StuffNode newNode = new StuffNode(null, f, null);
        StuffNode secondNode = sentinel.next;
        disConnectNodes(sentinel, secondNode);
        connectNodes(sentinel, newNode);
        connectNodes(newNode, secondNode);
    }


    public void addLast(Stuff item){
        sizeConstant += 1;
        StuffNode newNode = new StuffNode(null, item, null);
        if (sentinel == null) {
            sentinel = new StuffNode(newNode, item, newNode);
            return;
        }
        StuffNode lastNode = sentinel.prev;
        connectNodes(lastNode, newNode);
        newNode.next = sentinel;
        sentinel.prev = newNode;
    }

    public boolean isEmpty() {
        return sizeConstant == 0;
    }

    public int size() {
        return sizeConstant;
    }

    public void printDeque(){
        StuffNode p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    public Stuff removeFirst(){
        StuffNode first = sentinel.next;
        sentinel.next = first.next;
        sizeConstant -= 1;
        return first.item;
    }

    public Stuff removeLast() {
        StuffNode last = sentinel.prev;
        sentinel.prev = last.prev;
        sizeConstant -= 1;
        return last.item;
    }

    public Stuff get(int index){
        StuffNode p = sentinel.next;
        if (isEmpty()){
            return null;
        }
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }
}
