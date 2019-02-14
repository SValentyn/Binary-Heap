import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс содержит создание массива из 10-ти сгенерированных неповторяющихся элементов
 * которые будут составлять основу для создание бинарной (двоичной) кучи
 *
 * @author Syniuk Valentyn
 */
public class BinaryHeapAsArrayMain {

    public static void main(String[] args) {

        // список без повторений
        ArrayList<Integer> list = createArrayListWithoutRepeats();

        // заполняем массив элементами
        int[] array = new int[list.size()];
        for (int i = 0; i < 10; i++) {
            array[i] = list.get(i);
        }

        // создание бинарной кучи
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

    // создание списка из 10-ти сгенерированных неповторяющихся элементов
    static ArrayList<Integer> createArrayListWithoutRepeats() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i = 1; i <= 10; i++) {
            list.add(i);
        }
        Collections.shuffle(list); // "перемешиваем" элементы

        return list;
    }
}
