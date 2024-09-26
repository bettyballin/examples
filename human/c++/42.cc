cpp
#include <Windows.h>
#include <vector>
#include <iostream>

std::vector<char> file_data;

int main() {
    HANDLE efile = CreateFileA("example.txt", GENERIC_READ, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    if (efile == INVALID_HANDLE_VALUE) {
        std::cerr << "Error opening file." << std::endl;
        return 1;
    }

    DWORD fs = GetFileSize(efile, NULL);
    file_data.resize(fs);

    DWORD bt;
    if (!ReadFile(efile, file_data.data(), fs, &bt, NULL)) {
        std::cerr << "Error reading file." << std::endl;
        CloseHandle(efile);
        return 1;
    }

    if (fs != bt) {
        std::cerr << "Error reading file: incomplete read." << std::endl;
    }

    CloseHandle(efile);
    return 0;
}