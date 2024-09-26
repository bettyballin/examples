cpp
// No C++ code is required for this task. The code provided appears to be a set of bash commands.

// However, if you want to create a C++ program that executes these commands, you can use the system() function:

#include <iostream>
#include <cstdlib>

int main() {
    system("make generic64/libkeccak.a");
    system("sudo cp -a bin/generic64/libkeccak.a /usr/local/lib");
    system("sudo cp -a bin/generic64/libkeccak.a.headers /usr/local/include");
    return 0;
}