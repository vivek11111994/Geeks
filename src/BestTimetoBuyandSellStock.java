public class BestTimetoBuyandSellStock {
        public static void main (String[] args) {
                int[] prices = { 1, 2, 3, 4 };
                System.out.println (maxProfit (prices));
        }

        public static int maxProfit (int[] prices) {
                if (prices.length == 0)
                        return 0;

                int min = 0, maxProfit = 0;

                for (int i = 1; i < prices.length; i++) {
                        if (prices[i] < prices[min]) {
                                min = i;
                        }

                        if (min < i && prices[min] < prices[i]) {
                                if (maxProfit < (prices[i] - prices[min])) {
                                        maxProfit = prices[i] - prices[min];
                                }
                        }
                }

                return maxProfit;
        }
}
