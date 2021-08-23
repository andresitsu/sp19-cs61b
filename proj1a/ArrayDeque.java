public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int arraySize;
    private int currentIndexZero;

    private int nextFirst() {
        return stepBackwards(currentIndexZero);
    }

    private int nextLast() {
        return stepOnwards(currentLast());
    }

    /** Creates an empty list. */
    public ArrayDeque() {
        arraySize = 8;
        items = (T[]) new Object[arraySize];
        size = 0;
        currentIndexZero = 0;
    }

    private int stepBackwards(int x) {
        if (x - 1 >= 0) {
            x -= 1;
        } else {
            x = arraySize - x - 1;
        }
        return x;
    }

    private int stepOnwards(int x) {
        if (x + 1 < arraySize) {
            x += 1;
        } else {
            x = arraySize - x - 1;
        }
        return x;
    }

    /** Resizes the underlying array. */
    private void resize() {
        T[] a = (T[]) new Object[arraySize];
        System.arraycopy(items, currentIndexZero, a, 0, size - currentIndexZero);
        System.arraycopy(items, 0, a, size - currentIndexZero, currentIndexZero);
        items = a;
        currentIndexZero = 0;
    }

    private double sizeLargingFactor() {
        double currentlyUsedSpace = size;
        double n = 2;
        double usedRatio = size / (n * size);
        while (usedRatio < 0.25) {
            n = n - 0.1;
            usedRatio = size / (n * size);
        }
        return n;
    }

    private void checkResizing() {
        if (size == items.length) {
            arraySize = (int) Math.round(arraySize * sizeLargingFactor()) + 1;
            resize();
        }
    }

    /** Insert X into the front of the list. */
    public void addFirst(T x) {
        checkResizing();
        if (size == 0) {
            items[currentIndexZero] = x;
        } else {
            items[nextFirst()] = x;
            currentIndexZero = stepBackwards(currentIndexZero);
        }
        size += 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        checkResizing();
        if (size == 0) {
            items[currentIndexZero] = x;
        } else {
            items[nextLast()] = x;
        }
        size += 1;
    }

    private int currentLast() {
        if (currentIndexZero + size <= arraySize) {
            return currentIndexZero + size - 1;
        } else  {
            return size - (arraySize - currentIndexZero) - 1;
        }
    }

    /** Returns the item from the back of the list. */
    private T getLast() {
        return items[currentLast()];
    }

    private int toTrueIndex(int i) {
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
        return size == 0;
    }

    public void printDeque() {
        for (int i = 0; i < size - 1; i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println(get(size - 1));
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = getLast();
        items[currentLast()] = null;
        size -= 1;
        shrinking();
        return x;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = get(0);
        items[currentIndexZero] = null;
        currentIndexZero = stepOnwards(currentIndexZero);
        size -= 1;
        shrinking();
        return x;
    }

    private void shrinking() {
        double usageRatio = (double) size / (double) arraySize;
        if (usageRatio < 0.26 && arraySize > 32) {
            int oldSize = arraySize;
            arraySize = (int) Math.round(0.25 * arraySize + 1) ;
            T[] a = (T[]) new Object[arraySize];

            System.arraycopy(items, currentIndexZero, a, 0, size);
            items = a;
            currentIndexZero = 0;
        }
    }

    //    public ArrayDeque(ArrayDeque other) {
//        arraySize = other.arraySize;
//        items = (T[]) new Object[arraySize];
//        size = 0;
//        nextLast = 0;
//        nextFirst = arraySize - 1;
//        currentIndexZero = 0;
//
//        for (int i = 0; i < other.size(); i += 1) {
//            addLast((T) other.get(i));
//        }
//    }
}
