cpp
#include <iostream>
#include <fstream>
#include <string>

int main() {
    std::string command = "cl.exe /Ibuild/include /O2 /EHsc /GR /D_CONSOLE /DBOTAN_DLL= /nologo /c src/checksum/adler32/adler32.cpp /Fobuild/lib/adler32.obj";
    system(command.c_str());
    return 0;
}