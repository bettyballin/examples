#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // clone libsodium repository
    system("git clone git@github.com:algorand/libsodium.git");

    // change directory to libsodium
    chdir("libsodium");

    // run autogen.sh script
    system("sh autogen.sh");

    // run configure script
    system("./configure");

    // compile libsodium
    system("make");

    return 0;
}