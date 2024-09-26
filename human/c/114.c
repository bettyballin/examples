#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // Download openssl-1.0.2f.tar.gz
    system("curl https://www.openssl.org/source/openssl-1.0.2f.tar.gz -o openssl-1.0.2f.tar.gz");

    // Extract openssl-1.0.2f.tar.gz
    system("tar -xzf openssl-1.0.2f.tar.gz");

    // Change directory to openssl-1.0.2f
    system("cd openssl-1.0.2f");

    // Configure openssl
    system("./config");

    // Make openssl
    system("make");

    // Install openssl
    system("make install");

    return 0;
}