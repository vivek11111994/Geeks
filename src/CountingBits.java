public class CountingBits {
        public static void main (String[] args) {
                int num = 100;
                int[] arr = countBits (num);

                for (int i = 0; i < arr.length; i++) {
                        System.out.print (arr[i] + " ");
                }

                System.out.println ();
        }

        public static int[] countBits (int num) {
                int[] arr = new int[num + 1];

                arr[0] = 0;
                arr[1] = 1;

                for (int i = 2; i <= num; i++) {
                        if (i % 2 == 1) {
                                arr[i] = arr[i / 2] + 1;
                        } else {
                                arr[i] = arr[i / 2];
                        }
                }

                return arr;
        }
}
