cpp
#include <iostream>
#include <string>
#include <replxx.h>
#include <cryptopp/base64.h>
#include <cryptopp/filters.h>

using SecureString =
    std::basic_string<char, std::char_traits<char>, CryptoPP::AllocatorWithCleanup<char>>;

class PasswordInput {

    public:

        PasswordInput() {}

        void Read(const std::string& prompt) {
            rx_.set_prompt(prompt);
            rx_.set_modify_callback(std::bind(&PasswordInput::RxPwModifyCb, this, std::placeholders::_1, std::placeholders::_2));
            rx_.read_line();
        }

        inline const SecureString& Secret() const { return secret_; }

    private:

        void RxPwModifyCb(std::string& line, int& pos) {
            secret_.assign(line.begin(), line.end());
            line.clear();
        }

        Replxx rx_;
        SecureString secret_;
};

int main() {
    PasswordInput pi;
    pi.Read("Enter password: ");
    std::cout << std::endl;
    return 0;
}