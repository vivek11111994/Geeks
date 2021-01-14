public class AESEncryptionResponse {
        private byte[] encryptedData;
        private byte[] IV;

        public AESEncryptionResponse () {
        }

        public AESEncryptionResponse (byte[] encryptedData, byte[] IV) {
                this.encryptedData = encryptedData;
                this.IV = IV;
        }

        public byte[] getEncryptedData () {
                return encryptedData;
        }

        public void setEncryptedData (byte[] encryptedData) {
                this.encryptedData = encryptedData;
        }

        public byte[] getIV () {
                return IV;
        }

        public void setIV (byte[] IV) {
                this.IV = IV;
        }
}