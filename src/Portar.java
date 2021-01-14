public class Portar {
        public static void main (String[] args) {
                int[] houses = {12, 4, 10, 1, 1, 17};

                System.out.println (housesToRob (houses));
        }

        public static int housesToRob(int[] houses) {
                int[][] robbedHouses = new int[2][houses.length];
                int max = maxProfitUtils(houses, 0, 0, robbedHouses);

                System.out.println (robbedHouses);

                return max;
        }

        public static int maxProfitUtils(int[] houses, int pos, int sum, int[][] dp) {
                if(pos >= houses.length) {
                        return sum;
                }

                if(dp[0][pos] != 0) {
                        return dp[0][pos];
                }

                dp[1][pos] = 1;
                int robbed = maxProfitUtils(houses, pos+2, sum+houses[pos], dp);
                dp[1][pos] = 0;
                int notRobbed = maxProfitUtils(houses, pos+1, sum, dp);

                if(robbed > notRobbed) {
                        dp[1][pos] = 1;
                }

                return dp[0][pos] = Math.max(robbed, notRobbed);
        }
}
