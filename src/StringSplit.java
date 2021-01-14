public class StringSplit {
        public static void main (String[] args) {
                String Str = "https://flashblob.blob.core.windows.net/oem-firmware/firmware-cipher-mcu-1" +
                        ".1.4/13lnt5nsln1606292708.bin";

                for (String retval : Str.split ("[.]")) {
                        System.out.println (retval);
                }
        }
}
