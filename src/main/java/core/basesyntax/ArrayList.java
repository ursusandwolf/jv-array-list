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
        if (size >= capacity) {
            increase();
        }
        data[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] temp = data;
        capacity = (int) (INCREASE_FACTOR * capacity);
        data = (T[]) new Object[capacity];
        System.arraycopy(temp, 0, data, 0, size);
    }

    @Override
    public void add(T value, int index) {
        checkBound(index);
        T[] temp = (T[]) new Object[size + 1];
        T[] leftArray = (T[]) new Object[index+1];
        T[] newArray = (T[]) new Object[size +1];
        System.arraycopy(data, 0, leftArray, 0, index);
        leftArray[index] = value;
        //System.arraycopy(data, 0, leftArray, 0, index);
    }

    @Override
    public void addAll(List<T> list) {

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
