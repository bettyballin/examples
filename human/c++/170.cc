cpp
#include <iostream>
#include <fstream>
#include <filesystem>

int main() {
    // Create directory 'kbuild'
    std::filesystem::create_directory("kbuild");

    // Copy contents of 'KeccakCodePackage' to 'kbuild'
    for (const auto& entry : std::filesystem::directory_iterator("KeccakCodePackage")) {
        std::filesystem::copy(entry.path(), "kbuild", std::filesystem::copy_options::recursive);
    }

    // Change directory to 'kbuild'
    std::filesystem::current_path("kbuild");

    return 0;
}