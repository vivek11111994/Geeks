public class ArrangingCoins {
        public static void main (String[] args) {
                int n = 1;
                System.out.println (arrangeCoins (n));
        }

        public static int arrangeCoins (int n) {
                int count = 0;

                for (int i = 1; n >= i; i++) {
                        n = n - i;
                        count++;
                }

                return count;
        }
}
