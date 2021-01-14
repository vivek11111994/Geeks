import java.util.*;

public class FindNumberOfIceland {
        public FindNumberOfIceland (int n, int m) {
                int[][] visited = new int[n][m];
                SortedMap<Integer, Stack<Integer>> nodes = new TreeMap<> ();

                Iterator iterator = nodes.entrySet ().iterator ();

                nodes.get (1).push (1);

                for (Map.Entry<Integer, Stack<Integer>> entry : nodes.entrySet ()) {
                        System.out.println (entry.getValue ().pop ());
                }

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                                System.out.print (visited[i][j] + " ");
                        System.out.println ("\n");
                }
        }
}
