cpp
#include <iostream>
#include <fstream>
#include <string>
#include <stdexcept>

std::string exec(const std::string& cmd) {
    std::string result;
    FILE* pipe = popen(cmd.c_str(), "r");
    if (!pipe) throw std::runtime_error("popen() failed!");
    try {
        char buffer[128];
        while (fgets(buffer, 128, pipe) != NULL)
            result += buffer;
    } catch (...) {
        pclose(pipe);
        throw;
    }
    pclose(pipe);
    return result;
}

int main() {
    std::string inputPath, outputPath;
    std::cout << "Enter input file path: ";
    std::cin >> inputPath;
    std::cout << "Enter output file path: ";
    std::cin >> outputPath;

    std::string cmd = "openssl pkcs8 -topk8 -nocrypt -in " + inputPath + " -out " + outputPath;
    try {
        std::string output = exec(cmd);
        std::cout << output;
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }
    return 0;
}