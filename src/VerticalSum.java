import java.util.*;

public class VerticalSum {
        public static void main (String[] args) {
                TrNode root = new TrNode (1);
                root.left = new TrNode (2);
                root.right = new TrNode (3);
                root.left.left = new TrNode (4);
                root.left.right = new TrNode (5);
                root.right.left = new TrNode (6);
                root.right.right = new TrNode (7);

                Map<Integer, Integer> map = new HashMap<> ();

                findVerticalSum(root, 0,map);

                List<Integer> keyList = new ArrayList<> (map.keySet ());
                Collections.sort (keyList);

                for(Integer key : keyList) {
                        System.out.println ("distance " + key + " : " + "sum " + map.get (key));
                }
        }

        public static void findVerticalSum(TrNode root, int dist, Map<Integer, Integer> map) {
                if(root == null) {
                        return;
                }

                if(map.containsKey (dist)) {
                        int sum = map.get (dist);
                        map.put (dist, sum+root.val);
                } else {
                        map.put (dist, root.val);
                }

                if(root.left != null) {
                        findVerticalSum (root.left, dist-1, map);
                }

                if(root.right != null) {
                        findVerticalSum (root.right, dist+1, map);
                }
        }
}

class TrNode {
        int val;
        TrNode left;
        TrNode right;

        TrNode (int val) {
                this.val = val;
                this.left = null;
                this.right = null;
        }
}
