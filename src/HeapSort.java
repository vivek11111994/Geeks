public class HeapSort {
        public static void main (String[] args) {
                int[] arr = { 5, 9, 1, 2, 4, 3 };

                sort (arr);
        }

        public static void sort (int[] arr) {
                for (int i = (arr.length / 2) - 1; i >= 0; i--)
                        heapify (arr, i);

                int n = arr.length;

                for (int i = 0; i < arr.length; i++) {
                        System.out.print (arr[0] + " ");
                        arr[0] = arr[n - 1];
                        arr[n - 1] = Integer.MAX_VALUE;
                        n--;

                        heapify (arr, 0);
                }
        }

        public static void heapify (int[] arr, int i) {
                int smallest = i;
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < arr.length && arr[smallest] > arr[left]) {
                        smallest = left;
                }

                if (right < arr.length && arr[smallest] > arr[right]) {
                        smallest = right;
                }

                if (smallest != i) {
                        int tmp = arr[i];
                        arr[i] = arr[smallest];
                        arr[smallest] = tmp;

                        heapify (arr, smallest);
                }
        }
}
