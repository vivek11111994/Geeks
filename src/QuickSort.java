import java.util.Random;

public class QuickSort {
        public static void main (String[] args) {
                int[] arr = { 5, 9, 1, 2, 4, 3 };

                sort (arr, 0, arr.length - 1);

                for (int i = 0; i < arr.length; i++) {
                        System.out.print (arr[i] + " ");
                }
        }

        public static void sort (int[] arr, int start, int end) {
                if (start < end) {
                        int partitionPoint = partition (arr, start, end);

                        sort (arr, start, partitionPoint - 1);
                        sort (arr, partitionPoint + 1, end);
                }
        }

        public static int partition (int[] arr, int start, int end) {
                Random random = new Random ();
                int pivotPosition = start + random.nextInt (end - start);
                int pivot = arr[pivotPosition];

                int j = start - 1;
                for (int i = start; i <= end; i++) {
                        if (arr[i] < pivot) {
                                j++;

                                if (j == pivotPosition) {
                                        pivotPosition = i;
                                }

                                int tmp = arr[j];
                                arr[j] = arr[i];
                                arr[i] = tmp;
                        }
                }

                int tmp = arr[j + 1];
                arr[j + 1] = arr[pivotPosition];
                arr[pivotPosition] = tmp;

                return j + 1;
        }
}
