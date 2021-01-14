import java.util.HashSet;
import java.util.Stack;

public class UniqueEmailAddresses {
        public static void main (String[] args) {
                String[] input = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
                System.out.println (numUniqueEmails (input));
        }

        public static int numUniqueEmails(String[] emails) {
                HashSet<String> hashSet = new HashSet<> ();
                int[][] dp = new int[2][];
                Stack<Integer> stack = new Stack<> ();


                for(int i = 0; i < emails.length; i++) {
                        StringBuilder str = new StringBuilder (emails[i]);
                        StringBuilder tmpEmail = new StringBuilder ();
                        StringBuilder domainName = new StringBuilder ();
                        boolean found = false;

                        for(int j = 0; j < str.length (); j++) {
                                Character c = str.charAt (j);
                                if(c.equals ('@')) {
                                        found = false;
                                        tmpEmail.append (str.substring (j));
                                        break;
                                } else if(c.equals ('.') || found) {
                                        continue;
                                } else if(c.equals ('+')) {
                                        found = true;
                                } else {
                                        tmpEmail.append (c);
                                }
                        }

                        if(!hashSet.contains (tmpEmail.toString ())) {
                                hashSet.add (tmpEmail.toString ());
                        }
                }

                return hashSet.size ();
        }
}
