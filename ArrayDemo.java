public class ArrayDemo {
    public static void main(String[] args) {
        // Bigger array so we can insert later
        int[] numbers = new int[10];
        int currentSize = 5;

        // initialize with {1,2,3,4,5}
        for (int i = 0; i < currentSize; i++) {
            numbers[i] = i + 1;
        }

        System.out.print("Original array: ");
        printArray(numbers, currentSize);

        // Insert 99 at index 2
        currentSize = insertAtIndex(numbers, currentSize, 2, 99);
        System.out.print("After insertion: ");
        printArray(numbers, currentSize);

        // Delete element at index 4
        currentSize = deleteAtIndex(numbers, currentSize, 4);
        System.out.print("After deletion: ");
        printArray(numbers, currentSize);
    }

    // Insert value at given index
    public static int insertAtIndex(int[] arr, int size, int index, int value) {
        if (size == arr.length) {
            System.out.println("Array is full, cannot insert.");
            return size; // no change
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
            return size;
        }

        // Shift elements to the right
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        return size + 1; // new logical size
    }

    // Delete element at given index
    public static int deleteAtIndex(int[] arr, int size, int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return size;
        }

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return size - 1; // new logical size
    }

    // Print logical elements
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
