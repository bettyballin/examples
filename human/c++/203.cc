cpp
#include <iostream>
#include <string>
#include <functional>
#include <stdexcept>

// Assuming rx_ is an instance of a class with input and set_modify_callback methods
class RX {
public:
    char const* input(const std::string& prompt) {
        std::string line;
        std::cout << prompt;
        std::getline(std::cin, line);
        if (line.empty()) {
            return nullptr;
        }
        return line.c_str();
    }

    void set_modify_callback(std::function<void(std::string&, int&)> callback) {
        modify_callback = callback;
    }

    std::function<void(std::string&, int&)> modify_callback;
};

class PasswordInput {
public:
    PasswordInput() :
        rx_(),
        secret_()
    {
        rx_.set_modify_callback(std::bind(&PasswordInput::RxPwModifyCb, this, std::placeholders::_1, std::placeholders::_2));
    }

    void Read(const std::string& prompt) {
        char const* cinput{nullptr};
        do {
            cinput = rx_.input(prompt);
        } while ((cinput == nullptr) && (errno == EAGAIN));
    }

    void RxPwModifyCb(std::string& line, int& pos) {
        if (!line.empty()) {
            secret_.append(1, line[0]);
            line.clear();
        }
    }

private:
    RX rx_;
    std::string secret_;
};

int main() {
    PasswordInput pw;
    pw.Read("Enter password: ");
    return 0;
}