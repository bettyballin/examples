You provided a snippet of a Qt project file (.pro), not C++ code. Here is a corrected version of a simple C++ main function and a complete Qt project file:

**main.cpp:**
cpp
#include <iostream>
#include <sodium.h>

int main() {
    if (sodium_init() < 0) {
        std::cerr << "Error initializing libsodium" << std::endl;
        return 1;
    }

    std::cout << "libsodium initialized successfully" << std::endl;

    return 0;
}


**test_libsodium.pro:**
makefile
QT -= gui

TARGET = test_libsodium
CONFIG += console
CONFIG -= app_bundle

TEMPLATE = app

SOURCES += main.cpp

LIBS += -lsodium


You can use the following commands to compile and run this code:
bash
qmake test_libsodium.pro
make
./test_libsodium