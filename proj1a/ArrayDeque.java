public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int arraySize;

    /** Always returns the current zero index. */
    private int currentIndexZero;

    /** Creates an empty list. */
    public ArrayDeque() {
        arraySize = 8;
        items = (T[]) new Object[arraySize];
        size = 0;
        nextLast = 0;
        nextFirst = 1;
        currentIndexZero = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        arraySize = other.arraySize;
        items = (T[]) new Object[arraySize];
        size = 0;
        nextLast = 0;
        nextFirst = arraySize - 1;
        currentIndexZero = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public int stepBackwards(int x) {
        if (x - 1 >= 0) {
            x -= 1;
        } else {
            x = arraySize - x - 1;
        }
        return x;
    }

    public int stepOnwards(int x) {
        if (x + 1 < arraySize) {
            x += 1;
        } else {
            x = arraySize - x - 1;
        }
        return x;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize() {
        T[] a = (T[]) new Object[arraySize];
        System.arraycopy(items, currentIndexZero, a, 0, size - currentIndexZero);
        System.arraycopy(items, 0, a, size - currentIndexZero, currentIndexZero);
        items = a;
        nextLast = size;
        nextFirst = arraySize - 1;
        currentIndexZero = 0;
    }

    public double sizeLargingFactor() {
        return 1.25;
    }

    public void checkResizing() {
        if (size == items.length) {
            arraySize *= sizeLargingFactor();
            resize();
        }
    }

    /** Insert X into the front of the list. */
    public void addFirst(T x) {
        checkResizing();
        items[nextFirst] = x;
        size += 1;
        currentIndexZero = nextFirst;
        nextFirst = stepBackwards(nextFirst);
    }


    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        checkResizing();
        items[nextLast] = x;
        size = size + 1;
        nextLast = stepOnwards(nextLast);
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[currentIndexZero + size - 1];
    }

    public int toTrueIndex(int i) {
        if (currentIndexZero + i < arraySize) {
            return currentIndexZero + i;
        } else {
            return (currentIndexZero + i) - arraySize;
        }
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[toTrueIndex(i)];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printDeque() {
        for (int i = 0; i < size() - 1; i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println(get(size() - 1));
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = getLast();
        items[currentIndexZero + size - 1] = null;
        nextLast = stepBackwards(nextLast);
        size = size - 1;
        return x;
    }

    public T removeFirst() {
        T x = get(0);
        items[currentIndexZero] = null;
        nextFirst = stepOnwards(nextFirst);
        size -= 1;
        return x;
    }

}
