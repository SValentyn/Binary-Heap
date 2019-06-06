/**
 * Class for working with a binary heap based on an array
 */
class BinaryHeapAsArray {

    private int[] array;

    public BinaryHeapAsArray(int[] array) {
        this.array = array;
    }

    public void sort() {
        int length = array.length;

        // build a heap (rebuild)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // one element after another is retrieved from the heap.
        for (int i = length - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int length, int i) {
        int root = i; // initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than root
        if ((left < length) && (array[left] > array[root])) {
            root = left;
        }

        // if right child is larger than largest so far
        if ((right < length) && (array[right] > array[root])) {
            root = right;
        }

        // if largest is not root
        if (root != i) {
            swap(array, i, root);
            heapify(array, length, root); // recursively call for a subtree
        }
    }

    private void swap(int[] array, int i, int root) {
        int temp = array[i];
        array[i] = array[root];
        array[root] = temp;
    }

    public boolean isNotEmpty() {
        return (array != null);
    }

    public int getMin() {
        return array[0];
    }

    public int getMax() {
        return array[array.length - 1];
    }

    public void print() {
        for (int element : array) {
            System.out.print(element + ", ");
        }
    }

}
