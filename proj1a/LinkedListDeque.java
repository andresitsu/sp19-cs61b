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
        public StuffNode (Stuff i) {
            prev = null;
            item = i;
            next = null;
        }
    }

    private int sizeConstant;
    public StuffNode sentinel;

    public LinkedListDeque() {
        sentinel = new StuffNode(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        sizeConstant = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        sizeConstant = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((Stuff) other.get(i));
        }
    }

    public LinkedListDeque(Stuff x){
        sentinel = new StuffNode(x);
        StuffNode newNode = new StuffNode(x);
        insertNodeAs(sentinel, newNode, sentinel);
        sizeConstant = 1;
    }

    private void connectNodes(StuffNode a, StuffNode b) {
        a.next = b;
        b.prev = a;
    }

    public void insertNodeAs(StuffNode a, StuffNode b, StuffNode c) {
        connectNodes(a, b);
        connectNodes(b, c);
    }

    public void addFirst(Stuff f) {
        sizeConstant += 1;
        StuffNode newNode = new StuffNode(null, f, null);
        insertNodeAs(sentinel, newNode, sentinel.next);
    }


    public void addLast(Stuff item){
        sizeConstant += 1;
        StuffNode newNode = new StuffNode(null, item, null);
        StuffNode lastNode = sentinel.prev;
        insertNodeAs(lastNode, newNode, sentinel);
    }

    public boolean isEmpty() {
        return size() == 0;
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
        Stuff returnItem = first.item;
        StuffNode second = first.next;
        connectNodes(sentinel, second);
        sizeConstant -= 1;
        first = null;
        return returnItem;
    }

    public Stuff removeLast() {
        StuffNode last = sentinel.prev;
        Stuff returnItem = last.item;
        connectNodes(last.prev, sentinel);
        sizeConstant -= 1;
        last = null;
        return returnItem;
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

    public Stuff getRecursiveHelper(int index, StuffNode n){
        if (index == 0) {
            return n.item;
        }
        return getRecursiveHelper(index - 1, n.next);
    }

    public Stuff getRecursive(int index){
        return getRecursiveHelper(index, sentinel.next);
    }
}
