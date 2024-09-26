cpp
#include <iostream>
#include <string>
#include <fstream>
#include <dirent.h>

void search(const std::string& directory, const std::string& keyword) {
    DIR* dir;
    struct dirent* ent;
    if ((dir = opendir(directory.c_str())) != NULL) {
        while ((ent = readdir(dir)) != NULL) {
            std::string filename(ent->d_name);
            if (filename != "." && filename != "..") {
                std::string filepath = directory + "/" + filename;
                std::ifstream file(filepath);
                if (file.is_open()) {
                    std::string line;
                    int lineno = 1;
                    while (std::getline(file, line)) {
                        if (line.find(keyword) != std::string::npos) {
                            std::cout << filepath << ":" << lineno << ": " << line << std::endl;
                        }
                        lineno++;
                    }
                    file.close();
                } else {
                    std::cerr << "Error opening file " << filepath << std::endl;
                }
            }
        }
        closedir(dir);
    } else {
        std::cerr << "Error opening directory " << directory << std::endl;
    }
}

int main() {
    search(".", "DESEncryption");
    return 0;
}