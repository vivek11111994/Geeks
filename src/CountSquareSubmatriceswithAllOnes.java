public class CountSquareSubmatriceswithAllOnes {
        public static void main (String[] args) {
                int[][] arr = { { 0, 1, 1, 1 },
                        { 1, 1, 1, 1 },
                        { 0, 1, 1, 1 } };

                System.out.println (countSquares (arr));
        }

        public static int countSquares (int[][] arr) {
                int r = arr.length, c = arr[0].length;

                int[][] prefix2d = new int[r][c];
                prefix2d[0][0] = arr[0][0];

                for (int i = 1; i < c; i++) {
                        prefix2d[0][i] = prefix2d[0][i - 1] + arr[0][i];
                }

                for (int j = 1; j < r; j++) {
                        prefix2d[j][0] = prefix2d[j - 1][0] + arr[j][0];
                }

                for (int i = 1; i < r; i++) {
                        for (int j = 1; j < c; j++) {
                                prefix2d[i][j] =
                                        arr[i][j] + prefix2d[i - 1][j] + prefix2d[i][j - 1] - prefix2d[i - 1][j - 1];
                        }
                }

                int ans = 0;

                for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                                if (arr[i][j] == 1)
                                        ans++;
                        }
                }

                for (int len = 1; len < Math.min (r, c); len++) {
                        for (int i = 0; i < r; i++) {
                                for (int j = 0; j < c; j++) {
                                        int x = i + len;
                                        int y = j + len;
                                        if (x < r && y < c) {
                                                int sum = prefix2d[x][y];
                                                if (i > 0 && j > 0)
                                                        sum = sum - prefix2d[i - 1][y] - prefix2d[x][j - 1] + prefix2d[i - 1][j - 1];
                                                else if (i > 0)
                                                        sum = sum - prefix2d[i - 1][y];
                                                else if (j > 0)
                                                        sum = sum - prefix2d[x][j - 1];
                                                if (sum == (len + 1) * (len + 1)) {
                                                        ans++;
                                                }
                                        }
                                }
                        }
                }

                return ans;
        }
}
