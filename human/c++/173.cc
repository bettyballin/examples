cpp
#include <iostream>
#include <stdexcept>
#include <string>
#include <cstdlib>

int main() {
    std::string commands[] = {
        "bluetoothctl",
        "connect 00:11:22:33:44:55",
        "pair 00:11:22:33:44:55"
    };

    for (const auto& command : commands) {
        std::string cmd = command;
        if (command == "bluetoothctl") {
            cmd = "bluetoothctl --";
        }

        int result = system(cmd.c_str());
        if (result != 0) {
            throw std::runtime_error("Failed to execute command: " + cmd);
        }
    }

    return 0;
}