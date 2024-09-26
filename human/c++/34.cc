cpp
#include <iostream>
#include <fstream>
#include <cerrno>
#include <cstdlib>

int main() {
    std::ifstream inFile;
    inFile.open("ExpTable.bin", std::ios::in | std::ios::binary);
    if (!inFile) {
        std::cerr << "Unable to open ExpTable.bin: " << std::strerror(errno) << "\n";
        std::exit(EXIT_FAILURE);
    }

    char c;
    while (inFile.get(c)) {
        std::cout.put(c ^ '\x14');
    }

    inFile.close();
    return 0;
}