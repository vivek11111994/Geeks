import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EditFile {

        public static void main (String[] args) {

                try {
                        String verify, putData;
                        File file = new File ("file.txt");
                        file.createNewFile ();
                        file.createNewFile ();
                        FileOutputStream fos = new FileOutputStream (file);
                        DataOutputStream dos = new DataOutputStream (fos);

                        dos.writeChars ("Vivek");
                        //dos.writeLong(876);
                        dos.writeInt (89878);

                        //dos.close();

                        dos.writeLong (file.length ());


                        dos.close ();

                        System.out.println (new String (Files.readAllBytes (Paths.get ("file.txt"))));
                } catch (IOException e) {
                        e.printStackTrace ();
                }
        }

}