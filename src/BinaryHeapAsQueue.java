import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Класс для работы с бинарной кучей на основе дерева (с помощью очереди)
 *
 * @param <T> получаемый параметр типа
 */
class BinaryHeapAsQueue<T extends Comparable<T>> {

    private ArrayList<T> list;

    public BinaryHeapAsQueue() {
        this.list = new ArrayList<>();
    }

    public void insert(T element) {
        if (list.size() == 0) {
            list.add(element);
        } else {
            shiftUp(element);
        }
    }

    public T extractMax() throws NoSuchElementException {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        } else if (list.size() == 1) {
            return list.remove(0);
        }

        T element = list.get(0); // удаляемый элемент очереди
        list.set(0, list.remove(list.size() - 1));
        shiftDown();

        return element;
    }

    private void shiftUp(T element) {
        list.add(element);
        int sizeList = list.size();

        int currentIndex = sizeList - 1;
        while (currentIndex > 0) {

            int parentIndex = (currentIndex - 1) / 2;
            T parentItem = list.get(parentIndex);

            if (parentItem != null) {
                if (element.compareTo(parentItem) > 0) {
                    list.set(parentIndex, element);
                    list.set(currentIndex, parentItem);
                    currentIndex = parentIndex;
                    continue;
                }
            }
            break;
        }
    }

    private void shiftDown() {
        int curr = 0;
        int leftChild = 2 * curr + 1;

        while (leftChild < list.size()) {
            int max = leftChild;
            int rightChild = leftChild + 1;

            if (rightChild < list.size()) {
                if (list.get(rightChild).compareTo(list.get(1)) > 0) {
                    ++max;
                }
            }

            if (list.get(curr).compareTo(list.get(max)) < 0) {
                T tmp = list.get(curr);
                list.set(curr, list.get(max));
                list.set(max, tmp);
                curr = max;
                leftChild = 2 * curr + 1;
            } else {
                break;
            }
        }
    }

    public boolean isNotEmpty() {
        return !list.isEmpty();
    }

    public T getMax() {
        return list.get(0);
    }

    public T getMin() {
        return list.get(list.size() - 1);
    }

    public void changeValue(T element) {
        if (isNotEmpty()) {
            list.set(0, element);
            System.out.print("\n\nHeap after changing value: ");
            print();
            shiftDown();
        } else {
            System.out.println("Heap is empty!");
        }
    }

    public void print() {
        for (T element : list) {
            System.out.print(element.toString() + ", ");
        }
    }

}
