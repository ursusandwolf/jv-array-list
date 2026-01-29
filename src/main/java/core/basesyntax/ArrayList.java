package core.basesyntax;

public class ArrayList<T> implements List<T> {
    public static final int DEFAULT_CAPACITY = 10;
    public static final String IS_OUT_OF_BOUNDS = " is out of bounds";
    public static final double INCREASE_FACTOR = 1.5;
    private int capacity;
    private int size = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("wrong capacity");
        }
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index == size) {
            add(value);
            return;
        }
        checkBound(index);
        ensureCapacity();
        System.arraycopy(data, index,
                data, index + 1,
                size - index);
        data[index] = value;
        size++;
    }

    private void ensureCapacity() {
        ensureCapacity(1);
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int step) {
        if (size + step <= capacity) {
            return;
        }
        T[] temp = data;
        capacity = (int) (INCREASE_FACTOR * capacity) + 1;
        data = (T[]) new Object[capacity];
        System.arraycopy(temp, 0, data, 0, size);
    }

    @Override
    public void addAll(List<T> list) {
        int numNew;
        if (list == null || (numNew = list.size()) == 0) {
            return;
        }
        ensureCapacity(numNew);
        for (int i = 0; i < numNew; i++) {
            data[size + i] = list.get(i);
        }
        size += numNew;
    }

    @Override
    public T get(int index) {
        checkBound(index);
        return data[index];
    }

    private void checkBound(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException(index + IS_OUT_OF_BOUNDS);
        }
    }

    @Override
    public void set(T value, int index) {
        checkBound(index);
        data[index] = value;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T remove(T element) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
