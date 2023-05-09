import java.util.NoSuchElementException;

/*
 * Non resizable min heap using an array
 */
public class ArrayHeap {
    private final int[] prioQ; // store items at indices 1 to n
    private int noFItems; // number of items on priority queue
    private final int maxSize;

    public ArrayHeap(int maxSize) {
        this.maxSize = maxSize;
        this.noFItems = 0;
        this.prioQ = new int[this.maxSize];
    }

    private int leftChildIndex(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private int rightChildIndex(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    private int parentIdex(int childIndex) {
        return ((childIndex - 1) / 2);
    }

    private boolean hasLeftChild(int index) {
        return (leftChildIndex(index) < noFItems);
    }

    private boolean hasRightChild(int index) {
        return (rightChildIndex(index) < noFItems);
    }

    private boolean hasParent(int index) {
        return (parentIdex(index) >= 0);
    }

    private int leftChildData(int parentIndex) {
        return this.prioQ[leftChildIndex(parentIndex)];
    }

    private int rightChildData(int parentIndex) {
        return this.prioQ[rightChildIndex(parentIndex)];
    }

    private int parentData(int childIndex) {
        return this.prioQ[parentIdex(childIndex)];
    }

    private void swap(int index1, int index2) {
        int temp = this.prioQ[index1];
        this.prioQ[index1] = this.prioQ[index2];
        this.prioQ[index2] = temp;
    }

    private void bubble() {
        int pos = this.noFItems - 1; // index to last element in heap
        while (hasParent(pos) && parentData(pos) > prioQ[pos]) {
            swap(parentIdex(pos), pos);
            pos = parentIdex(pos);
        }
    }

    private void sink() {
        int pos = 0; // where we had the old root
        while (hasLeftChild(pos)) {
            int minChildPos = leftChildIndex(pos);
            if (hasRightChild(pos) && rightChildData(pos) < leftChildData(pos)) {
                minChildPos = rightChildIndex(pos);
            }
            if (this.prioQ[pos] < prioQ[minChildPos]) {
                break;
            } else {
                swap(pos, minChildPos);
            }
            pos = minChildPos;
        }
    }

    /**
     * Returns the minimum element of the priority queue
     *
     * @return first element of the array which is the element with lowest value
     */
    public int peek() {
        if (this.noFItems == 0) {
            System.out.println("Heap is empty");
            throw new NoSuchElementException();
        }
        return this.prioQ[0];
    }

    public int remove() {
        if (this.noFItems == 0) {
            System.out.println("Heap is empty");
            throw new NoSuchElementException();
        }
        int returnElement = this.prioQ[0];
        this.prioQ[0] = this.prioQ[this.noFItems - 1]; // set last element as root
        this.noFItems--;
        sink(); // let the new root sink down
        return returnElement;
    }

    public void add(int item) {
        if (this.noFItems == maxSize) {
            System.out.println("Heap is full. Can't add item");
            return;
        } // items in queue will always be a value that gives an index where there is
        // nothing inserted yet
        this.prioQ[this.noFItems] = item;
        this.noFItems++;
        bubble();
    }

    public void printHeap() {
        System.out.println("The Min Heap is ");
        for (int i = 0; i < this.noFItems / 2; i++) {
            System.out.println("PARENT : " + this.prioQ[i]);

            System.out.println("--LEFT CHILD : " + this.prioQ[2 * i + 1]);

            System.out.println("--RIGHT CHILD : " + this.prioQ[2 * i + 2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap(10);
        heap.add(10);
        heap.add(2);
        heap.add(7);
        heap.add(15);
        heap.add(90);
        heap.add(19);
        heap.add(8);
        heap.add(22);
        heap.add(9);
        heap.printHeap();
        heap.remove();
        heap.remove();
        System.out.println("-------------------");
        heap.printHeap();
    }
}