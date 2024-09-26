public void rotateLeft(byte[] data) {
    if (data == null || data.length == 0) return;
    
    // Shift first bit of the first byte
    byte firstBit = (byte) ((data[0] & 0x80) >> 7);
    
    for (int i = 0; i < data.length - 1; i++) {
        // Shift left and carry the first bit of the next byte
        data[i] = (byte) ((data[i] << 1) | ((data[i + 1] & 0x80) >> 7));
    }
    
    // Handle the last byte separately
    data[data.length - 1] = (byte) ((data[data.length - 1] << 1) | firstBit);
}