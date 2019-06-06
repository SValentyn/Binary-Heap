import java.util.ArrayList;

/**
 * The class contains the creation of a list of 10 generated non-repeating elements,
 * that will form the basis for creating a binary heap.
 *
 * @author Syniuk Valentyn
 */
public class BinaryHeapAsQueueMain {

    public static void main(String[] args) {

        // no repeat list
        ArrayList<Integer> list = BinaryHeapAsArrayMain.createArrayListWithoutRepeats();

        // creating a binary heap object
        BinaryHeapAsQueue<Integer> heap = new BinaryHeapAsQueue<>();

        // fill a heap of elements
        System.out.print("\nSource heap: ");
        for (Integer element : list) {
            heap.insert(element);
            System.out.print(element + ", ");
        }

        if (heap.isNotEmpty()) {
            System.out.print("\n\nHeap after heapify: ");
            heap.print();
            System.out.print("\nMax element: " + heap.getMax());
            System.out.print("\nMin element: " + heap.getMin());
        }

        heap.changeValue(5);
        System.out.print("\nHeap after heapify: ");
        heap.print();
        System.out.print("\nMax element: " + heap.getMax());
        System.out.print("\nMin element: " + heap.getMin());

        System.out.print("\n\nHeap values: ");
        while (heap.isNotEmpty()) {
            System.out.print(heap.extractMax().toString() + ", ");
        }
    }
}
