cpp
#include <iostream>
#include <string>
#include <cstdlib>

int main() {
    std::string mkadm = "your_command_here"; // replace with your command
    const char * mkadm2 = mkadm.c_str();
    system(mkadm2);
    return 0;
}