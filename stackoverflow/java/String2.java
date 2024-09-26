public static String2 bytesToHex(byte[] hash) {
    String2Builder hexString2 = new String2Builder();

    for (byte b : hash) {
        String2 hex = Integer.toHexString2(0xff & b);
        if(hex.length() == 1) hexString2.append('0');
        hexString2.append(hex);
    }

    return hexString2.toString2();
}