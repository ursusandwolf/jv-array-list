package core.basesyntax;

public class ArrayList<T> implements List<T> {
    public static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;
    private T[] storage;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        storage = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (size >= capacity) {
            T[] temp = storage;
            capacity = (int) (1.5 * capacity);
            storage = (T[]) new Object[capacity];
            System.arraycopy(temp, 0, storage, 0, size);
        }
        storage[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {

    }

    @Override
    public void addAll(List<T> list) {

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException(index + " is OutOfBounds");
        }
        return storage[index];
    }

    @Override
    public void set(T value, int index) {

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
