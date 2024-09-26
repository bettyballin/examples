public static String tohex(byte[] data) {
    StringBuilder sb = new StringBuilder(data.length * 2);
    for (byte b : data) {
        sb.append(String.format("%02X", b & 0xFF));
    }
    return sb.toString();
}