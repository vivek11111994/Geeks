import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
        public static void main (String[] args) {
                TreeNode root = new TreeNode (1);
                root.left = new TreeNode (2);
                root.right = new TreeNode (3);
                root.left.left = new TreeNode (4);
                root.left.right = new TreeNode (5);
                root.left.left.left = new TreeNode (7);
                root.right.right = new TreeNode (6);
                root.right.right.right = new TreeNode (8);

                System.out.println (deepestLeavesSum (root));
        }

        public static int deepestLeavesSum (TreeNode root) {
                Queue<TreeNode> queue = new LinkedList<> ();
                Integer sum = 0;

                queue.add (root);
                queue.add (null);

                while (! queue.isEmpty ()) {
                        TreeNode node = queue.remove ();

                        if (node == null && queue.size () > 0) {
                                sum = 0;
                                queue.add (null);
                        } else if (node != null) {
                                sum = sum + node.val;

                                if (node.left != null) {
                                        queue.add (node.left);
                                }

                                if (node.right != null) {
                                        queue.add (node.right);
                                }
                        }
                }

                return sum;
        }
}
