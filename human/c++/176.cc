cpp
#include <iostream>
#include <stdexcept>
#include <string>

int main() {
    try {
        std::string commands[] = {
            "bluetoothctl --agent KeyboardOnly",
            "bluetoothctl --agent KeyboardDisplay",
            "bluetoothctl --agent NoInputNoOutput",
            "bluetoothctl --agent DisplayOnly"
        };

        for (const auto& command : commands) {
            if (system(command.c_str()) != 0) {
                throw std::runtime_error("Failed to execute command: " + command);
            }
        }

        return 0;
    } catch (const std::exception& e) {
        std::cerr << e.what() << std::endl;
        return 1;
    }
}