cpp
#include <iostream>
#include <string>
#include <termios.h>
#include <unistd.h>

class PasswordInput {
public:
    PasswordInput() {}
    ~PasswordInput() {}

    void Read(const std::string& prompt) {
        struct termios oldt, newt;
        tcgetattr(STDIN_FILENO, &oldt);
        newt = oldt;
        newt.c_lflag &= ~(ICANON | ECHO);
        tcsetattr(STDIN_FILENO, TCSANOW, &newt);

        std::cout << prompt;
        std::string password;
        std::getline(std::cin, password);

        tcsetattr(STDIN_FILENO, TCSANOW, &oldt);

        secret_ = password;
    }

    std::string Secret() const {
        return secret_;
    }

private:
    std::string secret_;
};

void CalculatePassphrase(const char* password, size_t size) {
    // Your password calculation logic goes here...
    // For demonstration purposes, just print the password
    std::cout << "Password: " << password << std::endl;
}

int main() {
    PasswordInput pwi{}; // create password input handler
    pwi.Read("Password: "); // read the password
    std::cout << "\x1b[A" << "\33[2K\r"; // go one line up, delete line and go to beginning
    CalculatePassphrase(pwi.Secret().c_str(), pwi.Secret().size()); // Scrypt, pbkdf2, etc..
    return 0;
}