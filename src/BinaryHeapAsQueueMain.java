import java.util.ArrayList;

/**
 * Класс содержит создание списка из 10-ти сгенерированных неповторяющихся элементов
 * которые будут составлять основу для создания бинарной (двоичной) кучи
 *
 * @author Syniuk Valentyn
 */
public class BinaryHeapAsQueueMain {

    public static void main(String[] args) {

        // список без повторений
        ArrayList<Integer> list = BinaryHeapAsArrayMain.createArrayListWithoutRepeats();

        // создание бинарной кучи
        BinaryHeapAsQueue<Integer> heap = new BinaryHeapAsQueue<>();

        // заполняем кучу элементами
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