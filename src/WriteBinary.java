import java.io.IOException;

public class WriteBinary {
        public static void main (String[] args) throws IOException {
                /*String name = "Vivek Awasthi";
                int age = 527867857;
                long grade = 66000;
                File file = new File ("binary.txt" );
                FileOutputStream fileOutputStream = new FileOutputStream (file);

                fileOutputStream.write (name.getBytes ());
                //dataOutputStream.write (age);
                //fileOutputStream.write (getBytesFromLong (grade, 8));

                fileOutputStream.close ();

                name = "Rahul Awasthi";

                FileOutputStream atEnd = new FileOutputStream (file, true);
                atEnd.write (name.getBytes ());
                atEnd.close ();*/
                System.out.println (
                        "3045022100C1066613AF38A42E746F579896E19B03D79567122D73F7E802852F75617208CC02200782BC6E8538EC3454DDA5629F05D08BB6603E33A5FDE6D1FAB59B0049098B9E".length ());
        }

        public static byte[] getBytesFromLong (long value, int n) {
                byte[] res = new byte[n];

                for (int i = 0; i < n; i++) {
                        res[i] = (byte) (value >> 8 * i);
                }

                return res;
        }
}
