public class AESEncryption {
        private static final String key = "SecretKey";

        public static void main (String[] args) {
                String name = "Vivek Awasthi MNNIT Qualcomm Ola.";

                AESEncryptionResponse aesEncryptionResponse = AES.encrypt (name.getBytes (), key);

                System.out.println ("Encrypted data : " + new String (aesEncryptionResponse.getEncryptedData ()));

                System.out.println ("Decrypted data : " + new String (AES.decrypt (aesEncryptionResponse, key)));
        }
}
