public class ShootBallons {
        public static void main (String[] args) {
                int[] ballons = {};

                MaxSum (ballons, 10, 0, 0, 0, new int[10][50]);
        }

        public static int MaxSum(int[] ballons, int max, int currentBulletNo, int sum, int position, int[][] dp) {
                if(currentBulletNo > max || position >= ballons.length) {
                        return sum;
                }

                if(dp[currentBulletNo][position] != 0) {
                        return dp[currentBulletNo][position];
                }

                int hit = MaxSum (ballons, max, currentBulletNo+1, sum+ballons[position], position+3, dp);
                int nothit = MaxSum (ballons, max, currentBulletNo, sum, position+1, dp);

                return dp[currentBulletNo][position] = Math.max (hit, nothit);
        }
}
