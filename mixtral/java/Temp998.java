import java.security.NoSuchAlgorithmException;

public class Temp998 {
    private byte[] _formattedKey = "example_key".getBytes(); // Example key
    private String _message = "example_message"; // Example message

    public static void main(String[] args) {
        Temp998 temp = new Temp998();
        try {
            temp.createMac();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void createMac() throws NoSuchAlgorithmException {
        if ((_formattedKey != null) && (_message != null)) {
            // Convert message string into bytes
            byte[] _mesStringByte = _message.getBytes();

            // Initialize outer and inner pads
            byte o_pad = (byte) 0x5c;
            byte i_pad = (byte) 0x36;

            int blockSize = 64;

            // Create outer pad
            byte[] o_key_pad = new byte[blockSize];

            for(int i = 0; i < blockSize; i++){
                if(_formattedKey.length > i) {
                    o_key_pad[i] = (byte)(o_pad ^ _formattedKey[i]);
                } else {
                    // If key is shorter than block size pad with zeros
                    o_key_pad[i] = o_pad;
                }
            }

            // Create inner pad
            byte[] i_key_pad = new byte[blockSize];

            for(int i = 0; i < blockSize; i++){
                if(_formattedKey.length > i) {
                    i_key_pad[i] = (byte)(i_pad ^ _formattedKey[i]);
                } else {
                    // If key is shorter than block size pad with zeros
                    i_key_pad[i] = i_pad;
                }
            }

            byte[] tempByteArray1 = new byte[_mesStringByte.length + blockSize];

            System.arraycopy(i_key_pad, 0, tempByteArray1, 0, blockSize);

            // Concatenate message bytes to the end of inner pad
            for (int i = 0; i < _mesStringByte.length; ++i) {
                tempByteArray1[blockSize + i] =  _mesStringByte[i];
            }

            // You might want to add further processing here, like hashing tempByteArray1
        }
    }
}