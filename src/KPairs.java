public class KPairs {
        public int find_min (int[] a, int n, int k) {
                int sum = 0;
                for (int b : a) {
                        sum = sum + b / 2;
                }

                if (sum < k)
                        return - 1;

                return 2 * k + (n - 1);
        }
}
