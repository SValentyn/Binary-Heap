import java.util.ArrayList;
import java.util.Collections;

/**
 * The class contains the creation of an array of 10 generated non-repeating elements,
 * that will form the basis for creating a binary heap.
 *
 * @author Syniuk Valentyn
 */
public class BinaryHeapAsArrayMain {

    public static void main(String[] args) {

        // no repeat list
        ArrayList<Integer> list = createArrayListWithoutRepeats();

        // fill the array with elements
        int[] array = new int[list.size()];
        for (int i = 0; i < 10; i++) {
            array[i] = list.get(i);
        }

        // creating a binary heap object
        BinaryHeapAsArray heap = new BinaryHeapAsArray(array);

        if (heap.isNotEmpty()) {
            System.out.print("\nArray before sort: ");
            heap.print();
            System.out.print("\nMax element: " + heap.getMax());
            System.out.print("\nMin element: " + heap.getMin());

            System.out.print("\n\nArray after sort: ");
            heap.sort();
            heap.print();

            System.out.print("\nMax element: " + heap.getMax());
            System.out.print("\nMin element: " + heap.getMin());
        }
    }

    // create a list of 10 generated non-repeating elements
    static ArrayList<Integer> createArrayListWithoutRepeats() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i = 1; i <= 10; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list;
    }
}
