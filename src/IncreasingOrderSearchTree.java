public class IncreasingOrderSearchTree {
        public static TreeNode newRoot = null;
        public static TreeNode parent = new TreeNode ();

        public static void main (String[] args) {
                TreeNode root = new TreeNode (5);
                root.left = new TreeNode (3);
                root.right = new TreeNode (6);
                root.left.left = new TreeNode (2);
                root.left.right = new TreeNode (4);
                root.left.left.left = new TreeNode (1);
                root.right.right = new TreeNode (8);
                root.right.right.left = new TreeNode (7);
                root.right.right.right = new TreeNode (9);

        /*System.out.print("Inorder : ");
        printInorder(root);*/

                TreeNode node = increasingBST (root);

                System.out.print ("Inorder : ");
                printInorder (node);
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

        public static TreeNode increasingBST (TreeNode root) {
                if (root.left != null) {
                        increasingBST (root.left);
                }

                if (newRoot == null) {
                        newRoot = root;
                }

                parent.left = null;
                parent.right = root;
                parent = root;

                if (root.right != null) {
                        increasingBST (root.right);
                }

                return newRoot;
        }
}
