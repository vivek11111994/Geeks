import java.util.HashSet;
import java.util.Set;

public class SetExample {
        public static void main (String[] args) {
                Set<Integer> hashSet = new HashSet<Integer> ();

                hashSet.add (1);
                hashSet.add (3);
                hashSet.add (- 1);

                System.out.println (hashSet.contains (6));
        }
}
