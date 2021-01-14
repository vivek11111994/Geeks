public class MinCostClimbingStairs {
        public static void main (String[] args) {
                int[] cost = { 10, 15, 20 };
                System.out.println (minCostClimbingStairs (cost));
        }

        public static int minCostClimbingStairs (int[] cost) {
                int[] minCost = new int[cost.length];

                minCost[0] = cost[0];
                minCost[1] = cost[1];

                for (int i = 2; i < cost.length; i++) {
                        minCost[i] = Math.min (cost[i] + minCost[i - 2], cost[i] + minCost[i - 1]);
                }

                return Math.min (minCost[cost.length - 1], minCost[cost.length - 2]);
        }
}
