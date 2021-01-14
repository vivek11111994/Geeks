import java.util.*;

public class ReverseBinaryTreeLevelOrderTraversal {
        private static TreeNode root;

        public static void main (String[] args) {
                createTree ();

                levelOrderBottom ();
        }

        public static void printInorder (TreeNode node) {
                if (node.left != null) {
                        printInorder (node.left);
                }

                System.out.print (node.val + " ");

                if (node.right != null) {
                        printInorder (node.right);
                }
        }

        public static void createTree () {
                root = new TreeNode (3);
                root.left = new TreeNode (9);
                root.right = new TreeNode (20);
                root.right.left = new TreeNode (15);
                root.right.right = new TreeNode (7);
        }

        public static List<List<Integer>> levelOrderBottom () {
                List<List<Integer>> res = new ArrayList<> ();
                List<Integer> internalRes = new ArrayList<> ();
                Stack<TreeNode> stackExmpl = new Stack<> ();
                Queue<TreeNode> queue = new LinkedList<> ();

                if (root != null) {
                        queue.add (root);
                        queue.add (null);
                        stackExmpl.push (null);
                }

                while (! queue.isEmpty ()) {
                        TreeNode node = queue.remove ();

                        if (node != null) {
                                if (node.right != null) {
                                        queue.add (node.right);
                                }

                                if (node.left != null) {
                                        queue.add (node.left);
                                }
                        } else {
                                if (queue.size () > 0)
                                        queue.add (null);
                        }

                        stackExmpl.push (node);
                }

                while (! stackExmpl.empty ()) {
                        TreeNode node = stackExmpl.pop ();

                        if (node != null) {
                                internalRes.add (node.val);
                        } else {
                                if (internalRes.size () > 0)
                                        res.add (internalRes);
                                internalRes = new ArrayList<> ();
                        }
                }

                return res;
        }
}
