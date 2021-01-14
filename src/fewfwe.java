import org.w3c.dom.ls.LSInput;

import java.util.*;

public class fewfwe {
        public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();

                String[] pair = scanner.next().split(",");

                if(n <= 0 && n == (int)n) {
                        System.out.println("Error");
                } else if(pair.length != n) {
                        System.out.println("Overloaded");
                } else {
                        process(pair, n);
                }
        }

        public static void process(String[] pair, int n) {
                Map<String, List<String>> map = new HashMap<>();

                for(String str : pair) {
                        String[] tmp = str.split (":");

                        if (map.containsKey (tmp[1])) {
                                List<String> valueList = map.get (tmp[1]);
                                valueList.add (tmp[0]);

                                map.put (tmp[1], valueList);
                        } else {
                                List<String> valueList = new ArrayList<> ();
                                valueList.add (tmp[0]);

                                map.put (tmp[1], valueList);
                        }
                }

                List<String> keyList = new ArrayList<> (map.keySet ());
                Collections.sort (keyList, new Comparator<String> () {
                        @Override
                        public int compare (String o1, String o2) {
                                if(o1.compareTo (o2) > 0) {
                                        return 1;
                                }

                                return -1;
                        }
                });

                System.out.print ("{");
                for (String key : keyList) {
                        System.out.print (key + ":");
                        System.out.print (map.get (key));
                        System.out.print (",");
                }
                System.out.print ("}");
        }
}
