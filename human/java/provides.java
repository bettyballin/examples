package de.fencing_game.paul.examples;

import java.io.*;
import java.security.*;

public class SignatureOutputStream extends OutputStream {

    private OutputStream target;
    private Signature sig;

    public SignatureOutputStream(OutputStream target, Signature sig) {
        this.target = target;
        this.sig = sig;
    }

    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int offset, int len) throws IOException {
        target.write(b, offset, len);
        try {
            sig.update(b, offset, len);
        } catch (SignatureException ex) {
            throw new IOException(ex);
        }
    }

    public void flush() throws IOException {
        target.flush();
    }

    public void close() throws IOException {
        target.close();
    }

    public static void main(String[] args) {
        try {
            // Sample usage
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Signature sig = Signature.getInstance("SHA256withRSA");
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            sig.initSign(privateKey);

            SignatureOutputStream sigOutStream = new SignatureOutputStream(baos, sig);
            sigOutStream.write("Hello, World!".getBytes());
            sigOutStream.close();

            byte[] signature = sig.sign();
            System.out.println("Signature: " + bytesToHex(signature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}