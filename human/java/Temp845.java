public class Temp845 {
    public static void main(String[] args) {
        byte[] data = {0b00000001, 0b00000010, 0b00000100, 0b00001000};
        Temp845 temp = new Temp845();
        temp.rotateLeft(data);

        for (byte b : data) {
            System.out.println(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }
    }

    public void rotateLeft(byte[] data) {
        byte t = (byte)((data[0] >>> 7) & 0x001);
        for (int i = 0; i < (data.length - 1); ++i) {
            data[i] = (byte)(((data[i] << 1) & 0x0FE) | ((data[i + 1] >>> 7) & 0x001));
        }
        data[data.length - 1] = (byte)(((data[data.length - 1] << 1) & 0x0FE) | t);
    }
}