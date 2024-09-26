cpp
#include <iostream>
#include <stdexcept>
#include <cstdio>

void run_command(const char* cmd) {
    if (system(cmd) != 0) {
        throw std::runtime_error("Error running command");
    }
}

int main() {
    try {
        run_command("btmgmt connectable on");
        run_command("btmgmt bondable on");
        run_command("btmgmt io-cap");
        run_command("btmgmt 3");
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << '\n';
        return 1;
    }

    return 0;
}