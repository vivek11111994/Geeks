import java.util.*;

public class HorizontalSumTree {
        public static void main (String[] args) {
                Map<Integer, Integer> summap = new TreeMap<> ();

                //FindSum (root, summap, 0);
        }

        public static void FindSum(TNode root, Map<Integer, Integer> sumMap, int distance) {
                if(root == null) {
                        return;
                }

                if(sumMap.containsKey (distance)) {
                        Integer sum = sumMap.get (distance);
                        sumMap.put (distance, sum+root.val);
                } else {
                        sumMap.put (distance, root.val);
                }

                if(root.left != null) {
                        FindSum (root.left, sumMap, distance-1);
                }

                if(root.left != null) {
                        FindSum (root.left, sumMap, distance+1);
                }
        }
}

class TNode {
        int val;
        TNode left;
        TNode right;

        public TNode(int val) {
                this.val = val;
                left = null;
                right = null;
        }
}
