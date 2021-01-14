public class CountNumberofTeams {
        public static void main (String[] args) {
                int[] rating = { 1, 2, 3, 4 };

                System.out.println (numTeams (rating));
        }

        public static void printArray (int[] arr) {
                for (int i = 0; i < arr.length; i++) {
                        System.out.print (arr[i] + ", ");
                }
                System.out.println ();
        }

        public static int numTeams (int[] rating) {
                int[] larger = new int[rating.length];
                int[] smaller = new int[rating.length];
                int res = 0;

                for (int i = 0; i < rating.length; i++) {
                        for (int j = i + 1; j < rating.length; j++) {
                                if (rating[j] > rating[i]) {
                                        larger[i]++;
                                }

                                if (rating[j] < rating[i]) {
                                        smaller[i]++;
                                }
                        }
                }

                for (int i = 0; i < rating.length - 2; i++) {
                        for (int j = i + 1; j < rating.length - 1; j++) {
                                if (rating[j] > rating[i]) {
                                        res = res + larger[j];
                                }

                                if (rating[j] < rating[i]) {
                                        res = res + smaller[j];
                                }
                        }
                }

                return res;
        }
}
