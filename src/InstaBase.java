import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NTreeNode {
        private String val;
        private List<TreeNode> children = new ArrayList<> ();

        NTreeNode (String val, List<TreeNode> children) {
                this.val = val;
                this.children = children;
        }

        NTreeNode () {
        }

        public String getVal () {
                return val;
        }

        public void setVal (String val) {
                this.val = val;
        }

        public List<TreeNode> getChildren () {
                return children;
        }

        public void setChildren (List<TreeNode> children) {
                this.children = children;
        }
}

public class InstaBase {
        private static NTreeNode root = new NTreeNode ();

        public static void main (String[] args) {
                List<List<String>> list = new ArrayList<> ();
                List<String> l1 = Arrays.asList ("*", "a", "b", "c");
                List<String> l2 = Arrays.asList ("*", "a", "b", "e");
                List<String> l3 = Arrays.asList ("*", "a", "d");

                list.add (l1);
                list.add (l2);
                list.add (l3);
                int k = 0;

                while (k < list.size ()) {
                        for (int i = 0; i < list.get (k).size (); i++) {

                                root = new NTreeNode (list.get (k).get (i), new ArrayList<> ());


                        }
                }
        }
}
