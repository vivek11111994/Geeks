public class MatrixBlockSum {
        public static void main (String[] args) {
                int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
                matrixBlockSum (arr, 3);
        }

        public static int[][] matrixBlockSum (int[][] mat, int K) {
                int row = mat.length;
                int column = mat[0].length;
                int[][] rowSum = new int[row][column], columnSum = new int[row][column];

                for (int i = 0; i < row; i++) {
                        rowSum[i][0] = mat[i][0];

                        for (int k = 1; k <= K && k < column; k++) {
                                rowSum[i][0] = rowSum[i][0] + mat[i][k];
                        }

                        for (int j = 1; j < column; j++) {
                                if (j + K < column && j - K > 0)
                                        rowSum[i][j] = rowSum[i][j - 1] + mat[i][j + K] - mat[i][j - K - 1];
                                else if (j - K > 0)
                                        rowSum[i][j] = rowSum[i][j - 1] - mat[i][j - K - 1];
                                else if (j + K < column)
                                        rowSum[i][j] = rowSum[i][j - 1] + mat[i][j + K];
                                else
                                        rowSum[i][j] = rowSum[i][j - 1];
                        }
                }

        /*for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(rowSum[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("\n\n\n");*/

                for (int i = 0; i < column; i++) {
                        columnSum[0][i] = rowSum[0][i];

                        for (int k = 1; k <= K && k < row; k++) {
                                columnSum[0][i] = columnSum[0][i] + rowSum[k][i];
                        }

                        for (int j = 1; j < row; j++) {
                                if (j + K < row && j - K > 0)
                                        columnSum[j][i] = columnSum[j - 1][i] + rowSum[j + K][i] - rowSum[j - K - 1][i];
                                else if (j - K > 0)
                                        columnSum[j][i] = columnSum[j - 1][i] - rowSum[j - K - 1][i];
                                else if (j + K < row)
                                        columnSum[j][i] = columnSum[j - 1][i] + rowSum[j + K][i];
                                else
                                        columnSum[j][i] = columnSum[j - 1][i];
                        }
                }

        /*for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(columnSum[i][j] + "  ");
            }
            System.out.println();
        }*/

                return columnSum;
        }
}
