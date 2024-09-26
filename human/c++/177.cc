cpp
#include <regex>
#include <string>

template <class charT>
class basic_regex {
public:
    explicit basic_regex(const charT* p, std::regex_constants::syntax_option_type f = std::regex_constants::ECMAScript) 
        : regex_(p, f) {}

    void print() {
        std::cout << regex_.str() << std::endl;
    }

private:
    std::basic_regex<charT> regex_;
};

int main() {
    basic_regex<char> r("abc");
    r.print();
    return 0;
}