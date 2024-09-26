#include <stdio.h>
#include <string.h>

void encrypt(char *plain, int *cipher) {
    int key = 0x12345678;
    for (int i = 0; i < strlen(plain); i++) {
        cipher[i] = (plain[i] ^ key) - 124;
        key += 0x12345678;
    }
}

void decrypt(int *cipher, char *plain) {
    int key = 0x12345678;
    for (int i = 0; i < 16; i++) {
        plain[i] = (cipher[i] + 124) ^ key;
        key += 0x12345678;
    }
}

int main() {
    char plain[] = "test text 123";
    int cipher[16];
    char decrypt_text[16];

    printf("==C==\n");
    printf("plain:   %s\n", plain);
    encrypt(plain, cipher);
    printf("cipher:  ");
    for (int i = 0; i < 16; i++) {
        printf("%d ", cipher[i]);
    }
    printf("\n");
    decrypt(cipher, decrypt_text);
    printf("decrypt: %s\n", decrypt_text);

    return 0;
}


java
public class AES {
    public static void main(String[] args) {
        String plain = "test text 123";
        int[] cipher = new int[16];
        char[] decrypt_text = new char[16];

        System.out.println("==JAVA==");
        System.out.println("plain:   " + plain);
        encrypt(plain, cipher);
        System.out.print("cipher:  ");
        for (int i = 0; i < 16; i++) {
            System.out.print(cipher[i] + " ");
        }
        System.out.println();
        decrypt(cipher, decrypt_text);
        System.out.println("decrypt: " + new String(decrypt_text));
    }

    public static void encrypt(String plain, int[] cipher) {
        int key = 0x12345678;
        for (int i = 0; i < plain.length(); i++) {
            cipher[i] = (plain.charAt(i) ^ key) - 124;
            key += 0x12345678;
        }
    }

    public static void decrypt(int[] cipher, char[] plain) {
        int key = 0x12345678;
        for (int i = 0; i < 16; i++) {
            plain[i] = (char) ((cipher[i] + 124) ^ key);
            key += 0x12345678;
        }
    }
}