public class FindtheTownJudge {
        public static void main (String[] args) {
                int n = 1;
                int[][] trust = {};

                System.out.println (findJudge (n, trust));
        }

        public static int findJudge (int n, int[][] trust) {
                int[][] link = new int[n][2];

                for (int i = 0; i < trust.length; i++) {
                        link[trust[i][0] - 1][0]++;
                        link[trust[i][1] - 1][1]++;
                }

                for (int i = 0; i < link.length; i++) {
                        if (link[i][0] == 0 && link[i][1] == n - 1)
                                return i + 1;
                }

                return - 1;
        }
}
