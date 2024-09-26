cpp
#include <iostream>
#include <experimental/filesystem>

namespace fs = std::experimental::filesystem;

int main() {
    for (const auto& entry : fs::recursive_directory_iterator("."))
        std::cout << entry.path() << std::endl;
    return 0;
}