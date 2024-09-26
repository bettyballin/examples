This is not C code, it's Java code. Here is the corrected Java code:

java
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class AES {
  /*
   * Please realise that the following IV is terrible.
   * (As easy to crack as ROT13...)
   * Real situations should use a randomly generated IV.
   */
  static String IV = "AAAAAAAAAAAAAAAA";
  /* 
   * Note null padding on the end of the plaintext.
   */
  static String plaintext = "test text 123\0\0\0"; 
  static String encryptionKey = "0123456789abcdef";
  public static void main(String [] args) {
    try {

      System.out.println("==JAVA==");
      System.out.println("plain:   " + plaintext);

      byte[] cipher = encrypt(plaintext, encryptionKey);

      System.out.print("cipher:  ");
      for (int i=0; i<cipher.length; i++){
        System.out.print(new Integer(cipher[i])+" ");
      }
      System.out.println("");

      String decrypted = decrypt(cipher, encryptionKey);

      System.out.println("decrypt: " + decrypted);

    } catch (Exception e) {
      e.printStackTrace();
    } 
  }

  public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return cipher.doFinal(plainText.getBytes("UTF-8"));
  }

  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return new String(cipher.doFinal(cipherText),"UTF-8");
  }
}


If you want the equivalent C code, here it is (using OpenSSL library):


#include <openssl/aes.h>
#include <openssl/err.h>
#include <stdio.h>
#include <string.h>

#define IV "AAAAAAAAAAAAAAAA"
#define PLAINTEXT "test text 123\0\0\0"
#define ENCRYPTION_KEY "0123456789abcdef"

int main() {
    AES_KEY aes_key;
    unsigned char iv[AES_BLOCK_SIZE];
    unsigned char plaintext[strlen(PLAINTEXT)];
    unsigned char ciphertext[strlen(PLAINTEXT)];
    unsigned char decrypted[strlen(PLAINTEXT)];

    AES_set_encrypt_key((const unsigned char*)ENCRYPTION_KEY, 128, &aes_key);
    memcpy(iv, IV, AES_BLOCK_SIZE);
    memcpy(plaintext, PLAINTEXT, strlen(PLAINTEXT));

    printf("==C==\n");
    printf("plain:   %s\n", plaintext);

    AES_cbc_encrypt(plaintext, ciphertext, strlen(PLAINTEXT), &aes_key, iv, AES_ENCRYPT);

    printf("cipher:  ");
    for (int i = 0; i < strlen(PLAINTEXT); i++) {
        printf("%d ", ciphertext[i]);
    }
    printf("\n");

    AES_cbc_encrypt(ciphertext, decrypted, strlen(PLAINTEXT), &aes_key, iv, AES_DECRYPT);

    printf("decrypt: %s\n", decrypted);

    return 0;
}


Note: Make sure to link against OpenSSL library when compiling the C code. For example, if you're using GCC, use the following command:

bash
gcc -o aes aes.c -lcrypto