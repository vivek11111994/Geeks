import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class AES {
        private static final Logger logger = LoggerFactory.getLogger (AES.class);
        private static final String ALGO = "AES/CBC/PKCS5Padding";

        public static AESEncryptionResponse encrypt (byte[] clean, String key) throws RuntimeException {
                try {
                        // Generating IV.
                        int ivSize = 16;
                        byte[] iv = new byte[ivSize];
                        SecureRandom random = new SecureRandom ();
                        random.nextBytes (iv);
                        IvParameterSpec ivParameterSpec = new IvParameterSpec (iv);

                        // Hashing key.
                        MessageDigest digest = MessageDigest.getInstance ("SHA-256");
                        digest.update (key.getBytes (StandardCharsets.UTF_8));
                        byte[] keyBytes = new byte[16];
                        System.arraycopy (digest.digest (), 0, keyBytes, 0, keyBytes.length);
                        SecretKeySpec secretKeySpec = new SecretKeySpec (keyBytes, "AES");

                        // Encrypt.
                        Cipher cipher = Cipher.getInstance ("AES/CBC/PKCS5Padding");
                        cipher.init (Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
                        byte[] encrypted = cipher.doFinal (clean);

                        return new AESEncryptionResponse (encrypted, iv);
                } catch (Exception e) {
                        logger.error ("Encryption Error : " + e.getMessage ());
                        throw new RuntimeException ("Encryption error");
                }
        }

        public static byte[] decrypt (AESEncryptionResponse aesEncryptionResponse, String key) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec (aesEncryptionResponse.getIV ());

                try {
                        // Hash key.
                        byte[] keyBytes = new byte[16];
                        MessageDigest md = MessageDigest.getInstance ("SHA-256");
                        md.update (key.getBytes ());
                        System.arraycopy (md.digest (), 0, keyBytes, 0, keyBytes.length);
                        SecretKeySpec secretKeySpec = new SecretKeySpec (keyBytes, "AES");

                        // Decrypt.
                        Cipher cipherDecrypt = Cipher.getInstance ("AES/CBC/PKCS5Padding");
                        cipherDecrypt.init (Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
                        return cipherDecrypt.doFinal (aesEncryptionResponse.getEncryptedData ());
                } catch (Exception e) {
                        logger.error ("Decryption error : {}", e.getMessage ());
                        throw new RuntimeException ("Decryption error");
                }
        }
}