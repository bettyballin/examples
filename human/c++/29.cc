cpp
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <openssl/aes.h>
#include <openssl/md5.h>
#include <openssl/sha.h>
#include <openssl/hmac.h>
#include <openssl/rand.h>

using namespace std;

// Function to read password from user
string readPasswd() {
    string password;
    cout << "Enter encryption password: ";
    cin >> password;
    return password;
}

int main() {
    // Salt
    unsigned char salt[] = {
        0xc7, 0x73, 0x21, 0x8c,
        0x7e, 0xc8, 0xee, 0x99
    };

    // Iteration count
    int count = 20;

    // Prompt user for encryption password.
    string password = readPasswd();

    // Create PBE key
    unsigned char key[24];
    PKCS5_PBKDF2_HMAC_SHA1(password.c_str(), password.size(), salt, 8, count, 24, key);

    // Our cleartext
    string cleartext = "This is another example";

    // Encrypt the cleartext
    AES_KEY aesKey;
    AES_set_encrypt_key(key, 192, &aesKey);
    unsigned char ciphertext[cleartext.size()];
    AES_encrypt((const unsigned char*)cleartext.c_str(), ciphertext, &aesKey);

    // Print the ciphertext
    for (int i = 0; i < cleartext.size(); i++) {
        cout << hex << (int)ciphertext[i];
    }
    cout << endl;

    return 0;
}