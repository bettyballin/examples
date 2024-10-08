public class Temp1653 {
    public static void main(String[] args) {
        JCECC jcecc = new JCECC();
        jcecc.generatePointData();
        jcecc.multiplyBasepoint();
        byte[] Qpwx = { (byte) 0x9d, (byte) 0x33, (byte) 0x9b, (byte) 0x33, (byte) 0x96, (byte) 0xae, (byte) 0x4a,
                (byte) 0x81, (byte) 0x63, (byte) 0x88, (byte) 0xa1, (byte) 0x4c, (byte) 0x79, (byte) 0xab, (byte) 0x3a,
                (byte) 0x8d, (byte) 0xd4, (byte) 0x95, (byte) 0xfa, (byte) 0x4c, (byte) 0x53, (byte) 0xf0, (byte) 0xd4,
                (byte) 0x07, (byte) 0x65, (byte) 0x79, (byte) 0x02, (byte) 0x2e, (byte) 0xf2, (byte) 0xaa, (byte) 0xeb,
                (byte) 0x68 };
        byte[] Qpwy = { (byte) 0xda, (byte) 0xd9, (byte) 0x14, (byte) 0x82, (byte) 0xe2, (byte) 0x08, (byte) 0x59,
                (byte) 0x0f, (byte) 0xd3, (byte) 0x16, (byte) 0xbf, (byte) 0x95, (byte) 0x94, (byte) 0x80, (byte) 0xf5,
                (byte) 0xec, (byte) 0x2c, (byte) 0x17, (byte) 0x46, (byte) 0x3e, (byte) 0xc8, (byte) 0xfc, (byte) 0x8f,
                (byte) 0x63, (byte) 0x03, (byte) 0x06, (byte) 0x49, (byte) 0xb4, (byte) 0x52, (byte) 0xcd, (byte) 0xdd,
                (byte) 0xa8 };
        jcecc.addPoints(jcecc.Qx, jcecc.Qy, Qpwx, Qpwy);
        Qpwx = jcecc.getRx();
        Qpwy = jcecc.getRy();
    }
}

class JCECC {
    public byte[] Qx;
    public byte[] Qy;
    private byte[] Rx;
    private byte[] Ry;

    public void generatePointData() {
        // Implement the method according to your logic
    }

    public void multiplyBasepoint() {
        // Implement the method according to your logic
    }

    public void addPoints(byte[] Qx, byte[] Qy, byte[] Qpwx, byte[] Qpwy) {
        // Implement the method according to your logic
        // Update Rx and Ry accordingly
    }

    public byte[] getRx() {
        // Return the computed Rx
        return Rx;
    }

    public byte[] getRy() {
        // Return the computed Ry
        return Ry;
    }
}