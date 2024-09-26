cpp
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

std::string decode(const std::string& line) {
    // implement your decode function here
    return line; // placeholder implementation
}

int main()
{
    std::string line = "hello";

    {
        line = decode(line);
        std::ofstream myfile("example.txt", std::ios::binary);
        myfile.write(line.data(), line.size());

        std::cout << std::hex << std::setfill('0');
        for (char c : line)
            std::cout << "\\x" << std::setw(2) << (0xff & c);
        std::cout << std::endl;
    }

    {
        std::ifstream myfile("example.txt", std::ios::binary | std::ios::ate);
        int filesize = (int)myfile.tellg();
        line.resize(filesize);
        myfile.seekg(0);
        myfile.read(&line[0], filesize);
        line = decode(line);
        std::cout << line << std::endl;
    }

    return 0;
}