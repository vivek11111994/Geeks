import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourcetoTarget {

        public static void main (String[] args) {
                int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };

                for (List<Integer> path : allPathsSourceTarget (graph)) {
                        System.out.println ("path : " + path);
                }
        }

        public static List<List<Integer>> allPathsSourceTarget (int[][] graph) {
                List<List<Integer>> res = new ArrayList<> ();
                List<Integer> onePath = new ArrayList<> ();
                onePath.add (0);

                allPathsSourceTargetUtils (graph, 0, onePath, res);

                return res;
        }

        private static void allPathsSourceTargetUtils (int[][] graph, int i, List<Integer> onePath,
                                                       List<List<Integer>> res) {
                if (i == graph.length - 1) {
                        res.add (new ArrayList<> (onePath));
                        return;
                }

                for (int j = 0; j < graph[i].length; j++) {
                        onePath.add (graph[i][j]);
                        allPathsSourceTargetUtils (graph, graph[i][j], onePath, res);
                        onePath.remove (onePath.size () - 1);
                }
        }
}