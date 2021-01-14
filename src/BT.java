import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GFG {
        public static void main (String[] args) {
                Scanner sc = new Scanner (System.in);

                int t = sc.nextInt ();

                while (t-- > 0) {
                        int n = sc.nextInt ();
                        int[] arr = new int[n];

                        for (int i = 0; i < n; i++) {
                                arr[i] = sc.nextInt ();
                        }

                        int min = n - 1, i;
                        Queue<Integer> queue = new LinkedList<> ();

                        for (i = n - 1; i >= 0; i--) {
                                if (arr[i - 1] < arr[i]) {
                                        int tmp = arr[i - 1];
                                        arr[i - 1] = arr[min];
                                        arr[i] = tmp;
                                        break;
                                } else {
                                        queue.add (arr[i - 1]);
                                }
                        }

                        for (int j = i + 1; j < n; j++) {
                                arr[j] = queue.remove ();
                        }

                        for (i = 0; i < n; i++) {
                                System.out.print (arr[i] + " ");
                        }
                }
        }
}