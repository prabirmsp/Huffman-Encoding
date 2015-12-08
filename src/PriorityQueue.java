import java.util.Arrays;

public class PriorityQueue<T extends Comparable<? super T>> {

    private T[] arr;
    int size;

    public PriorityQueue(int size) {
        arr = (T[]) new Comparable[size];
        this.size = 0;
    }

    private int parentOf(int i) {
        return (i - 1) / 2;
    }

    private int rightChildOf(int i) {
        return i * 2 + 2;
    }

    private int leftChildOf(int i) {
        return i * 2 + 1;
    }

    public void add(T value) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size] = value;
        siftUp(size++);
    }

    private void siftUp(int index) {
        int indexOfParent = parentOf(index);

        if (index != 0 && arr[index].compareTo(arr[indexOfParent]) <= 0) {
            T temp = arr[index];
            arr[index] = arr[indexOfParent];
            arr[indexOfParent] = temp;
            siftUp(indexOfParent);
        }
    }

    public T poll() {
        if (size > 0) {
            T ret = arr[0];
            arr[0] = arr[--size];
            arr[size] = null;
            siftDown(0);
            return ret;
        }
        throw new IllegalStateException("PriorityQueue is empty.");
    }

    private void siftDown(int index) {
        int rightChild = rightChildOf(index), leftChild = leftChildOf(index);
        if (leftChild < size) {
            int child = -1;
            if (arr[leftChild].compareTo(arr[index]) <= 0) {
                child = leftChild;
            }
            if (rightChild < size && arr[rightChild].compareTo(arr[leftChild]) < 0) {
                child = rightChild;
            }
            if (child > 0) {
                T temp = arr[index];
                arr[index] = arr[child];
                arr[child] = temp;
                siftDown(child);
            }
        }
    }

    public T peek() {
        if (size > 0)
            return arr[0];
        throw new IllegalStateException("PriorityQueue is empty.");
    }

    public void printTree() {
        for (int i = 0; i < size; i++) {
            System.out.printf(arr[i].toString() + " ");
            if (((i) % 2) == 0)
                System.out.printf(" | ");

        }
        System.out.println();
        System.out.println();
    }
}
