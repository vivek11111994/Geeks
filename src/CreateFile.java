import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CreateFile {
        public static void main (String[] args) throws IOException {
                // Accept a string
                String str = "Jai " +
                        " Kumar";

                // attach a file to FileWriter
                File file = new File ("output.txt");
                FileWriter fw = new FileWriter (file, true);

                // read character wise from string and write
                // into FileWriter
                fw.write ("\n\n");
                for (int i = 0; i < str.length (); i++)
                        fw.write (str.charAt (i));

                System.out.println ("Writing successful");
                //close the file
                fw.close ();
        }
}